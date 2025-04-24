package com.avilcor.campina.grande.Spring.Avilcor.Project.controller;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.ClientResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Client;
import com.avilcor.campina.grande.Spring.Avilcor.Project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll() {
        return ResponseEntity.ok().body(clientService.findAll());
    }
}
