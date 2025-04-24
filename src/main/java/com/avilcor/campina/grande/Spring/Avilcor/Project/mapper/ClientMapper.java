package com.avilcor.campina.grande.Spring.Avilcor.Project.mapper;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.ClientCreatDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.ClientResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Client;

public class ClientMapper {

    public static Client toEntity(ClientCreatDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        return client;
    }

    public static ClientResponseDTO toResponse(Client client) {
        return new ClientResponseDTO(client.getId(), client.getName(), client.getEmail(), client.getOrders().stream().map(x -> ));


    }
}
