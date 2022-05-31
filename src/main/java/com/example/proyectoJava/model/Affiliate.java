package com.example.proyectoJava.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="affiliate")
public class Affiliate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "names",nullable = false,length = 50)
    private String names;

    @Column(name = "surnames",nullable = false,length = 50)
    private String surnames;

    @Pattern(regexp = "^[0-9]*$", message = "No cumple con la expresión ^[0-9]*$")
    @Size(min=8,max=8, message = "Debe tener 8 dígitos")
    @Column(name = "dni",nullable = false,length = 8,unique = true)
    private String dni;

    @Column(name = "phone",nullable = false,length = 9)
    private String phone;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "idAfp",nullable = false)
    private Long idAfp;

}
