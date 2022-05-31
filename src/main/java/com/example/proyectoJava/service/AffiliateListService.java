package com.example.proyectoJava.service;

import com.example.proyectoJava.model.Affiliate;
import com.example.proyectoJava.model.AffiliateList;

import java.util.List;

public interface AffiliateListService {

    List<AffiliateList> findAll();

    AffiliateList create(AffiliateList affiliateList);

    AffiliateList update(AffiliateList affiliateList);

    AffiliateList findById(Long id);

    AffiliateList delete(Long id);
}
