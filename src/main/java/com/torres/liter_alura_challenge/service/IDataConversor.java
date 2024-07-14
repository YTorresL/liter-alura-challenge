package com.torres.liter_alura_challenge.service;

public interface IDataConversor {
    <T> T getData(String json, Class<T> clazz);
}
