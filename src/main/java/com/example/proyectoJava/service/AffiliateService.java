package com.example.proyectoJava.service;


import com.example.proyectoJava.model.Affiliate;

import java.util.List;

public interface AffiliateService {

    List<Affiliate> findAll();

    Affiliate create(Affiliate affiliate);

    Affiliate update(Affiliate affiliate);

    Affiliate findById(Long id);

    Affiliate delete(Long id);

}
