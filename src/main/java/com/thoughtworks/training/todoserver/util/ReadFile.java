package com.thoughtworks.training.todoserver.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.todoserver.model.Todo;

import java.io.IOException;
import java.util.List;

public class ReadFile {
    public static List<Todo> read(String dataString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Todo> data = objectMapper.readValue(dataString, new TypeReference<List<Todo>>() {
        });
        return data;
    }
}
