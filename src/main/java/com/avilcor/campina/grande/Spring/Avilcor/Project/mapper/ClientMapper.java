package com.avilcor.campina.grande.Spring.Avilcor.Project.mapper;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request.ClientRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.response.ClientResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.summary.ClientSummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Client;

public class ClientMapper {

    public static Client toEntity(ClientRequestDTO clientDTO) {
        Client client = new Client();

        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());

        return client;
    }

    public static ClientSummaryDTO toSummary(Client client) {;
        ClientSummaryDTO clientSummaryDTO = new ClientSummaryDTO();

        setClientDTO(clientSummaryDTO, client);

        return clientSummaryDTO;
    }

    private static void setClientDTO(ClientSummaryDTO clientSummaryDTO, Client client) {
        clientSummaryDTO.setId(client.getId());
        clientSummaryDTO.setName(client.getName());
        clientSummaryDTO.setEmail(client.getEmail());
    }

    public static ClientResponseDTO toResponse(Client client) {
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();

        setClientDTO(clientResponseDTO, client);
        clientResponseDTO.setOrders(client.getOrders().stream().map(OrderMapper::toSummary).toList());

        return clientResponseDTO;
    }

}
