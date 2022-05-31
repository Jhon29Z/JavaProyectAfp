package com.example.proyectoJava.api;

import com.example.proyectoJava.exception.ModelNotFoundException;
import com.example.proyectoJava.model.Afp;
import com.example.proyectoJava.service.AfpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "afp")
public class AfpApi {

    @Autowired
    AfpService afpService;

    @GetMapping
    ResponseEntity<List<Afp>> findAll(){ /*Tener mas control con los codigos Http estatus que se devuelven*/
        return ResponseEntity.ok(afpService.findAll());
    }

    @PostMapping
    ResponseEntity<Afp> create(@RequestBody Afp afp){
        Afp response = afpService.create(afp);
        return new ResponseEntity<Afp>(response, HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<Afp> update(@RequestBody Afp afp){
        Afp response = afpService.update(afp);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<Afp> findById(@PathVariable("id") Long id){
        Afp response = afpService.findById(id);
        if (response.getId() == null){
            throw new ModelNotFoundException("ID no encontrado");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id  ){
        Afp response = afpService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
