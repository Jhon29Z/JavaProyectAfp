package com.example.proyectoJava.api;

import com.example.proyectoJava.exception.ModelNotFoundException;
import com.example.proyectoJava.model.Affiliate;
import com.example.proyectoJava.model.Afp;
import com.example.proyectoJava.service.AffiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "affiliate")
public class AffiliateApi {

    @Autowired
    AffiliateService affiliateService;

    @GetMapping
    ResponseEntity<List<Affiliate>> findAll(){ /*Tener mas control con los codigos Http estatus que se devuelven*/
        return ResponseEntity.ok(affiliateService.findAll());
    }

    @PostMapping
    ResponseEntity<Affiliate> create(@Valid @RequestBody Affiliate affiliate){
        Affiliate response = affiliateService.create(affiliate);
        Afp afp =new Afp();
        if (response.getIdAfp() != afp.getId()){
            throw new ModelNotFoundException("No se puede afiliar, Afp distinto");
        }
        return new ResponseEntity<Affiliate>(response, HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<Affiliate> update(@Valid @RequestBody Affiliate affiliate){
        Affiliate response = affiliateService.update(affiliate);
        Afp afp =new Afp();
        if (response.getIdAfp() != afp.getId()){
            throw new ModelNotFoundException("No se puede afiliar, Afp distinto");
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<Affiliate> findById(@PathVariable("id") Long id){
        Affiliate response = affiliateService.findById(id);
        if (response.getId() == null){
            throw new ModelNotFoundException("ID no encontrado");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id  ){
        Affiliate response = affiliateService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
