package com.example.kiemtra.service.impl;

import com.example.kiemtra.model.HomeStay;
import com.example.kiemtra.repository.IHomeStayRepository;
import com.example.kiemtra.service.IHomeStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeStayService implements IHomeStayService {
    @Autowired
    private IHomeStayRepository homeStayRepository;

    @Override
    public Iterable<HomeStay> findAll() {
        return homeStayRepository.findAll();
    }

    @Override
    public void save(HomeStay homeStay) {
        homeStayRepository.save(homeStay);
    }

    @Override
    public Optional<HomeStay> findById(int id) {
        return homeStayRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        homeStayRepository.deleteById(id);
    }

    @Override
    public Iterable<HomeStay> findByName(String keyword) {
        return homeStayRepository.findByName(keyword);
    }
}
