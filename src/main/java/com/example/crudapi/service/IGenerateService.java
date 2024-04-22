package com.example.crudapi.service;

import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();
    T save(T t);
    Optional<T> findById(int id);
    void delete(int id);
}
