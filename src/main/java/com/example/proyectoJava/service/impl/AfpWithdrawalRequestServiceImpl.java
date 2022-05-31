package com.example.proyectoJava.service.impl;

import com.example.proyectoJava.model.Affiliate;
import com.example.proyectoJava.model.AfpWithdrawalRequest;
import com.example.proyectoJava.repository.AffiliateListRepository;
import com.example.proyectoJava.repository.AfpWithdrawalRequestRepository;
import com.example.proyectoJava.service.AfpWithdrawalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfpWithdrawalRequestServiceImpl implements AfpWithdrawalRequestService {
    @Autowired
    AfpWithdrawalRequestRepository afpWithdrawalRequestRepository;

    @Override
    public List<AfpWithdrawalRequest> findAll() {
        return afpWithdrawalRequestRepository.findAll();
    }

    @Override
    public AfpWithdrawalRequest create(AfpWithdrawalRequest afpWithdrawalRequest) {
        return afpWithdrawalRequestRepository.save(afpWithdrawalRequest);
    }

    @Override
    public AfpWithdrawalRequest update(AfpWithdrawalRequest afpWithdrawalRequest) {
        return afpWithdrawalRequestRepository.save(afpWithdrawalRequest);
    }

    @Override
    public AfpWithdrawalRequest findById(Long id) {
        Optional<AfpWithdrawalRequest> op = afpWithdrawalRequestRepository.findById(id);
        return op.isPresent() ? op.get() : new AfpWithdrawalRequest() ;
    }

    @Override
    public AfpWithdrawalRequest delete(Long id) {
        afpWithdrawalRequestRepository.deleteById(id);
        return null;
    }
}
