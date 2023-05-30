package com.alepsdev.performance;

import com.alepsdev.performance.repository.DataRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class DataProcessor {

    private final DataRepository dataRepository;

    public DataProcessor(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void processFile(MultipartFile file) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            Data data = new Data(fields[0], fields[1], fields[2]);
            dataRepository.save(data);
        }
        reader.close();
    }
}
