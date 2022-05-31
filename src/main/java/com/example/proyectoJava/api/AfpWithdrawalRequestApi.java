package com.example.proyectoJava.api;

import com.example.proyectoJava.exception.ModelNotFoundException;
import com.example.proyectoJava.model.AffiliateList;
import com.example.proyectoJava.model.AfpWithdrawalRequest;
import com.example.proyectoJava.service.AffiliateListService;
import com.example.proyectoJava.service.AfpWithdrawalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "afpWithdrawalRequestApi")
public class AfpWithdrawalRequestApi {

    @Autowired
    AfpWithdrawalRequestService afpWithdrawalRequestService;

    @GetMapping
    ResponseEntity<List<AfpWithdrawalRequest>> findAll(){
        return ResponseEntity.ok(afpWithdrawalRequestService.findAll());
    }

    @PostMapping
    ResponseEntity<AfpWithdrawalRequest> create(@Valid @RequestBody AfpWithdrawalRequest afpWithdrawalRequest){
        AfpWithdrawalRequest response = afpWithdrawalRequestService.create(afpWithdrawalRequest);
        if (response.getWithdrawalAmount() > 4000){
            throw new ModelNotFoundException("No se puede registrar la solicitud. Monto mayor que el permitido");
        }
        if (response.getWithdrawalAmount() < 4000 *0.5){
            throw new ModelNotFoundException("Monto mínimo no cubierto por favor revise el monto mínimo a retirar");
        }
        return new ResponseEntity<AfpWithdrawalRequest>(response, HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<AfpWithdrawalRequest> update(@Valid @RequestBody AfpWithdrawalRequest afpWithdrawalRequest){
        AfpWithdrawalRequest response = afpWithdrawalRequestService.update(afpWithdrawalRequest);
        if (response.getWithdrawalAmount() > 4000){
            throw new ModelNotFoundException("No se puede registrar la solicitud. Monto mayor que el permitido");
        }
        if (response.getWithdrawalAmount() < 4000 *0.5){
            throw new ModelNotFoundException("Monto mínimo no cubierto por favor revise el monto mínimo a retirar");
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<AfpWithdrawalRequest> findById(@PathVariable("id") Long id){
        AfpWithdrawalRequest response = afpWithdrawalRequestService.findById(id);
        if (response.getId() == null){
            throw new ModelNotFoundException("ID no encontrado");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id  ){
        AfpWithdrawalRequest response = afpWithdrawalRequestService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
