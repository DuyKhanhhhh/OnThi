package com.example.onthiapib1.service;

import com.example.onthiapib1.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IGenerateService<User>{
    Page<User> findAll(Pageable pageable);
    Iterable<User> findByName(String name);
}
