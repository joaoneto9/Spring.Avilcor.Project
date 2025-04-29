package com.avilcor.campina.grande.Spring.Avilcor.Project.api.service;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.ClientRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.ClientResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Client;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller.exception.ConflictException;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller.exception.NotFoundException;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper.ClientMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findByEmail(String email) throws NotFoundException {
        Optional<Client> client = clientRepository.findByEmail(email);
        return client.orElseThrow(() -> new NotFoundException("client not found"));
    }

    @Transactional
    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {

        if (clientRepository.findByEmail(clientRequestDTO.getEmail()).isPresent())
            throw new ConflictException("this client alredy exist");

        Client client = ClientMapper.toEntity(clientRequestDTO);
        clientRepository.save(client);
        return ClientMapper.toResponse(client);

    }

    public List<String> autoCompleteEmail(String emailPrefix) {
        List<Client> clients = clientRepository.findByEmailStartingWithIgnoreCase(emailPrefix); // busca similares ao que foi buscado
        return clients.stream()
                .map(Client::getEmail)
                .toList();
    }



}
