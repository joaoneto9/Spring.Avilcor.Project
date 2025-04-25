package com.avilcor.campina.grande.Spring.Avilcor.Project.service;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request.ClientRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.response.ClientResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.mapper.ClientMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientResponseDTO> findAll() {
        return clientRepository.findAll().stream().map(ClientMapper::toResponse).toList();
    }

    public ResponseEntity<String> save(ClientRequestDTO clientRequestDTO) {
        if (clientRepository.findByEmail(clientRequestDTO.getEmail()).isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Client alredy exists.");

        clientRepository.save(ClientMapper.toEntity(clientRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body("Client has been created.");
    }

    public ResponseEntity<?> findByEmail(String email) {
        if (clientRepository.findByEmail(email).isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com esse email nao encontrado.");

        return ResponseEntity.ok().body(ClientMapper.toResponse(clientRepository.findByEmail(email).get()));
    }



}
