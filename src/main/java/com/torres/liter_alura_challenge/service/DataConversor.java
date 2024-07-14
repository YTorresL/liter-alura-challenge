package com.torres.liter_alura_challenge.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConversor implements IDataConversor {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
