package com.example.proyectoJava.api;

import com.example.proyectoJava.exception.ModelNotFoundException;
import com.example.proyectoJava.model.Affiliate;
import com.example.proyectoJava.model.AffiliateList;
import com.example.proyectoJava.service.AffiliateListService;
import com.example.proyectoJava.service.AffiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "affiliateList")
public class AffiliateListApi {

    @Autowired
    AffiliateListService affiliateListService;

    @GetMapping
    ResponseEntity<List<AffiliateList>> findAll(){ /*Tener mas control con los codigos Http estatus que se devuelven*/
        return ResponseEntity.ok(affiliateListService.findAll());
    }

    @PostMapping
    ResponseEntity<AffiliateList> create(@Valid @RequestBody AffiliateList affiliateList){
        AffiliateList response = affiliateListService.create(affiliateList);
        return new ResponseEntity<AffiliateList>(response, HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<AffiliateList> update(@Valid @RequestBody AffiliateList affiliateList){
        AffiliateList response = affiliateListService.update(affiliateList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<AffiliateList> findById(@PathVariable("id") Long id){
        AffiliateList response = affiliateListService.findById(id);
        if (response.getId() == null){
            throw new ModelNotFoundException("ID no encontrado");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id  ){
        AffiliateList response = affiliateListService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
