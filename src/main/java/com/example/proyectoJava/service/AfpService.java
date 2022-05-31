package com.example.proyectoJava.service;


import com.example.proyectoJava.model.Afp;

import java.util.List;

public interface AfpService {

    List<Afp> findAll();

    Afp create(Afp afp);

    Afp update(Afp afp);

    Afp findById(Long id);

    Afp delete(Long id);
}
