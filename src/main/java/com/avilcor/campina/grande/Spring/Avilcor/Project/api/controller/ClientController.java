package com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.ClientRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.ClientResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper.ClientMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // para teste
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll() {
        return ResponseEntity.ok(clientService.findAll().stream().map(ClientMapper::toResponse).toList());
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<ClientResponseDTO> findByEmail( @PathVariable String email) {
        return ResponseEntity.ok(ClientMapper.toResponse(clientService.findByEmail(email)));
    }

    @GetMapping(value = "/autocomplete/{emailPrefix}")
    public ResponseEntity<List<String>> autoCompleteEmailClient(@PathVariable String emailPrefix) {
        return ResponseEntity.ok(clientService.autoCompleteEmail(emailPrefix));
    }

    @PostMapping(value = "/send")
    public ResponseEntity<ClientResponseDTO> save(@RequestBody @Valid ClientRequestDTO clientRequestDTO) {
        return ResponseEntity.ok(clientService.save(clientRequestDTO));
    }

}
