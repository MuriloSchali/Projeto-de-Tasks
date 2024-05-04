package TASK4.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class S3Service {

    @Value("${s3.bucket.name}")
    private String bucketName;

    @Value("${s3.region}")
    private String region;

    public Boolean saveToS3(Map<String, Integer> dataApi) {

        ByteArrayInputStream inputStream = null;

        try {
            // Configure S3 client with the specified region
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(region)
                    .build();

            // Convert data to JSON
            byte[] dataJson = new ObjectMapper().writeValueAsBytes(dataApi);
            inputStream = new ByteArrayInputStream(dataJson);

            // Configure object metadata
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(dataJson.length);

            // Send object to S3
            PutObjectResult result = s3Client.putObject(new PutObjectRequest(bucketName, "gender-data.json",
                    inputStream, metadata));

            // Check if the operation was successful
            return result != null;
        } catch (Exception e) {
            e.getMessage();
            return false;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
