package com.example.kiemtra.service;

import com.example.kiemtra.model.HomeStay;

public interface IHomeStayService extends IGenerateService<HomeStay> {
    Iterable<HomeStay> findByName(String keyword);

}
