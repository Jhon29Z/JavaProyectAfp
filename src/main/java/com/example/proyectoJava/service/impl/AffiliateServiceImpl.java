package com.example.proyectoJava.service.impl;

import com.example.proyectoJava.model.Affiliate;
import com.example.proyectoJava.repository.AffiliateRepository;
import com.example.proyectoJava.service.AffiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffiliateServiceImpl implements AffiliateService {

    @Autowired
    AffiliateRepository affiliateRepository;

    @Override
    public List<Affiliate> findAll() {
        return affiliateRepository.findAll();
    }

    @Override
    public Affiliate create(Affiliate affiliate) {
        return affiliateRepository.save(affiliate);
    }

    @Override
    public Affiliate update(Affiliate affiliate) {
        return affiliateRepository.save(affiliate);
    }

    @Override
    public Affiliate findById(Long id) {
        Optional<Affiliate> op = affiliateRepository.findById(id);
        return op.isPresent() ? op.get() : new Affiliate() ;
    }

    @Override
    public Affiliate delete(Long id) {
        affiliateRepository.deleteById(id);
        return null;
    }
}
