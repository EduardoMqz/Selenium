package com.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonReader {
    private static final ObjectMapper mapper = new ObjectMapper();

    // Read JSON into a Map (flexible key-value pairs)
    public static Map<String, Object> readJsonAsMap(String filePath) throws IOException {
        return mapper.readValue(new File(filePath), Map.class);
    }

    // Read JSON into a custom class (e.g., Config.class)
    public static <T> T readJson(String filePath, Class<T> clazz) throws IOException {
        return mapper.readValue(new File(filePath), clazz);
    }

}
