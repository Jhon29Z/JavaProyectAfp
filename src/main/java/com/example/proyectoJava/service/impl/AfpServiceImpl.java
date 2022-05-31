package com.example.proyectoJava.service.impl;

import com.example.proyectoJava.model.Afp;
import com.example.proyectoJava.repository.AfpRepository;
import com.example.proyectoJava.service.AfpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfpServiceImpl implements AfpService {

    @Autowired
    AfpRepository afpRepository;

    @Override
    public List<Afp> findAll() {
        return afpRepository.findAll();
    }

    @Override
    public Afp create(Afp afp) {
        return afpRepository.save(afp);
    }

    @Override
    public Afp update(Afp afp) {
        return afpRepository.save(afp);
    }

    @Override
    public Afp findById(Long id) {
        Optional<Afp> op = afpRepository.findById(id);
        return op.isPresent() ? op.get() : new Afp() ;
    }

    @Override
    public Afp delete(Long id) {
        afpRepository.deleteById(id);
        return null;
    }
}
