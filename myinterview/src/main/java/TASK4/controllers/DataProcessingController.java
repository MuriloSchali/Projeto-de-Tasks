package TASK4.controllers;

import TASK4.services.DataProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process")
public class DataProcessingController {

    @Autowired
    private DataProcessor dataProcessor;

    @GetMapping("/saveToS3")
    public ResponseEntity<String> saveToS3() {
        try {
            String result = dataProcessor.searchData();
            return ResponseEntity.ok(result);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing the request. " + e.getMessage());
        }
    }
}