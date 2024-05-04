package TASK4.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataProcessor {

    private RestTemplate restTemplate;

    /*public RestTemplate getRestTemplate() {
        return restTemplate;
    }*/

    /*@Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

    @Autowired
    public void setS3Service(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @Value("${api.url}")
    private String apiUrl;

    @Autowired
    S3Service s3Service;

    public String searchData() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity;

        try {
            responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        } catch (RestClientException e) {
            return "Error accessing the API." + e.getMessage();
        }

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();

            // Check if the response body contains the error message
            assert responseBody != null;
            if (responseBody.contains("Runtime.ExitError")) {
                return "Error. " + responseBody;
            }

            try {
                // Deserialize the JSON response into a list of maps
                List<Map<String, Object>> data = new ObjectMapper().readValue(responseBody, new TypeReference<>() {
                });

                // Count of records by gender
                Map<String, Integer> contagemPorGenero = new HashMap<>();
                for (Map<String, Object> record : data) {
                    String gender = (String) record.get("gender");
                    contagemPorGenero.put(gender, contagemPorGenero.getOrDefault(gender, 0) + 1);
                }

                boolean sucess = s3Service.saveToS3(contagemPorGenero);
                if (!sucess) {
                    return "Amazon S3 fails to save data.";
                } else {
                    return "Data successfully saved in S3!";
                }
            } catch (IOException e) {
                throw new RuntimeException("Error processing the API response. " + e.getMessage());
            }
        } else {
            return "Error fetching data from the API. " + responseEntity.getStatusCodeValue();
        }
    }
}