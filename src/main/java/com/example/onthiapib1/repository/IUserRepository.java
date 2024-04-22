package com.example.onthiapib1.repository;

import com.example.onthiapib1.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;



@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Page<User> findAll(Pageable pageable);
    Iterable<User> findByNameContaining(String name);
}
