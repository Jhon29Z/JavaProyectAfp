package com.example.proyectoJava.service;

import com.example.proyectoJava.model.AffiliateList;
import com.example.proyectoJava.model.AfpWithdrawalRequest;

import java.util.List;

public interface AfpWithdrawalRequestService {

    List<AfpWithdrawalRequest> findAll();

    AfpWithdrawalRequest create(AfpWithdrawalRequest afpWithdrawalRequest);

    AfpWithdrawalRequest update(AfpWithdrawalRequest afpWithdrawalRequest);

    AfpWithdrawalRequest findById(Long id);

    AfpWithdrawalRequest delete(Long id);
}
