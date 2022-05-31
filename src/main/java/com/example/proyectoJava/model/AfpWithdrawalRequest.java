package com.example.proyectoJava.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="afpWithdrawalRequest")
public class AfpWithdrawalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[0-9]*$", message = "No cumple con la expresión ^[0-9]*$")
    @Size(min=8,max=8, message = "Debe tener 8 dígitos")
    @Column(name = "dni",nullable = false,length = 8,unique = true)
    private String dni;

    @Column(name = "withdrawalAmount",nullable = false)
    private Double withdrawalAmount;

    @Column(name = "idAfp",nullable = false)
    private Long idAfp;
}
