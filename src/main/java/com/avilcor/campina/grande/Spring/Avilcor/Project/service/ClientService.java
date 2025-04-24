package com.avilcor.campina.grande.Spring.Avilcor.Project.service;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.ClientResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.mapper.ClientMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientResponseDTO> findAll() {
        return clientRepository.findAll().stream().map(ClientMapper::toResponse).toList();
    }
}
