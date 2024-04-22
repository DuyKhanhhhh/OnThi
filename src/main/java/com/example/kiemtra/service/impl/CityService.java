package com.example.kiemtra.service.impl;

import com.example.kiemtra.model.City;
import com.example.kiemtra.model.HomeStay;
import com.example.kiemtra.repository.ICityRepository;
import com.example.kiemtra.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CityService implements ICityService {
    @Autowired
    private ICityRepository cityRepository;
    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public Optional<City> findById(int id) {
        return cityRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        cityRepository.deleteById(id);
    }

}
