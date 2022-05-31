package com.example.proyectoJava.service.impl;

import com.example.proyectoJava.model.Affiliate;
import com.example.proyectoJava.model.AffiliateList;
import com.example.proyectoJava.repository.AffiliateListRepository;
import com.example.proyectoJava.repository.AffiliateRepository;
import com.example.proyectoJava.service.AffiliateListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffiliateListServiceImpl implements AffiliateListService {

    @Autowired
    AffiliateListRepository affiliateListRepository;

    @Override
    public List<AffiliateList> findAll() {
        return affiliateListRepository.findAll();
    }

    @Override
    public AffiliateList create(AffiliateList affiliateList) {
        return affiliateListRepository.save(affiliateList);
    }

    @Override
    public AffiliateList update(AffiliateList affiliateList) {
        return affiliateListRepository.save(affiliateList);
    }

    @Override
    public AffiliateList findById(Long id) {
        Optional<AffiliateList> op = affiliateListRepository.findById(id);
        return op.isPresent() ? op.get() : new AffiliateList() ;
    }

    @Override
    public AffiliateList delete(Long id) {
        affiliateListRepository.deleteById(id);
        return null;
    }
}
