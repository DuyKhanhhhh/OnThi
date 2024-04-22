package com.example.onthiapib1.repository;

import com.example.onthiapib1.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends CrudRepository<Role, Integer> {
}
