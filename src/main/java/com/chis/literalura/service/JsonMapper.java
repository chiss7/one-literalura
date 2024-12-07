package com.chis.literalura.service;

public interface JsonMapper {
    <T> T fromJsonToClass(String json, Class<T> class_);
}
