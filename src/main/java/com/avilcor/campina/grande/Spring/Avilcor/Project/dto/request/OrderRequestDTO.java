package com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request;

import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Client;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderRequestDTO {

    @NotNull
    private Client client;
    @NotNull
    private List<ActivityRequestIdDTO> services;

    public OrderRequestDTO() {

    }

    public OrderRequestDTO(Client client, List<ActivityRequestIdDTO> services) {
        this.client = client;
        this.services = services;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ActivityRequestIdDTO> getServices() {
        return services;
    }

    public void setServices(List<ActivityRequestIdDTO> services) {
        this.services = services;
    }
}
