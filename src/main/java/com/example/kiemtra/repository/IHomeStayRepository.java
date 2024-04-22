package com.example.kiemtra.repository;

import com.example.kiemtra.model.HomeStay;
import org.springframework.data.repository.CrudRepository;

public interface IHomeStayRepository extends CrudRepository<HomeStay, Integer> {
    Iterable<HomeStay> findByName(String keyword);
}
