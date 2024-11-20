package me.vasujain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileHandler {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Customer> readCustomersFromFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Customer>>() {});
    }

    public static void writeCustomersToFile(String filePath, List<Customer> customers) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), customers);
    }
}
