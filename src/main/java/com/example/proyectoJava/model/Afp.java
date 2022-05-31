package com.example.proyectoJava.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="afp")
public class Afp {

    public static Long Id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description",nullable = false,length = 50)
    private String description;

}
