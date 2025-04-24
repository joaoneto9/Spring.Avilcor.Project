package com.avilcor.campina.grande.Spring.Avilcor.Project.mapper;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request.ClientRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.response.ClientResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Client;

public class ClientMapper {

    public static Client toEntity(ClientRequestDTO clientDTO) {
        Client client = new Client();

        System.out.println(clientDTO.getName());
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());

        return client;
    }

    public static ClientResponseDTO toResponse(Client client) {;
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();

        setClientDTO(clientResponseDTO, client);

        return clientResponseDTO;
    }

    private static void setClientDTO(ClientResponseDTO clientResponseDTO, Client client) {
        clientResponseDTO.setId(client.getId());
        clientResponseDTO.setName(client.getName());
        clientResponseDTO.setEmail(client.getEmail());
    }

}
