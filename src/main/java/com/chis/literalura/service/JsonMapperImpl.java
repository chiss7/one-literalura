package com.chis.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapperImpl implements JsonMapper {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T fromJsonToClass(String json, Class<T> class_){
        try {
            return objectMapper.readValue(json, class_);
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }
}
