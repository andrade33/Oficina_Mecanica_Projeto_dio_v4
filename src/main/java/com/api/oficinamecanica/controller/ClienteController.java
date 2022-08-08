package com.api.oficinamecanica.controller;

import java.util.List;

import javax.validation.Valid;

import com.api.oficinamecanica.entity.form.ClienteForm;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.oficinamecanica.entity.Cliente;
import com.api.oficinamecanica.service.impl_service.ClienteServiceImpl;

@RestController
@RequestMapping (value = "/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteServiceImpl service; 
    
    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody ClienteForm form){
        return ResponseEntity.ok(service.serviceCreateCli(form));
    }

    @GetMapping
    public List<Cliente> getAll() {
        return service.servicefindAllCli();
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.serviceFindByIdCli(id));
    }
    /*
    @PostMapping
    public Cliente inserir(@RequestBody ClienteForm form) {
        return service.serviceCreateCli(form);
    }
    */
    
}
