package com.avilcor.campina.grande.Spring.Avilcor.Project.controller;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request.ClientRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.response.ClientResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.service.ClientService;
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
        return ResponseEntity.ok().body(clientService.findAll());
    }

    @PostMapping(value = "/send")
    public ResponseEntity<String> save(@RequestBody ClientRequestDTO clientRequestDTO) {
        return clientService.save(clientRequestDTO);
    }
}
