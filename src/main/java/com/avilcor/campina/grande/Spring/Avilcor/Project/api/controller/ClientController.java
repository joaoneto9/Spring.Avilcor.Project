package com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.ClientRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.ClientResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<?> findByEmail( @PathVariable String email) {
        return ResponseEntity.ok(clientService.findByEmail(email));
    }

    @PostMapping(value = "/send")
    public ResponseEntity<?> save(@RequestBody ClientRequestDTO clientRequestDTO) {
        return ResponseEntity.ok(clientService.save(clientRequestDTO));
    }



}
