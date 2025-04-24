package com.avilcor.campina.grande.Spring.Avilcor.Project.dto;

import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Client;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderCreateDTO {

    @NotNull
    private Client client;
    @NotNull
    private List<ServiceIdDTO> services;

    public OrderCreateDTO() {

    }

    public OrderCreateDTO(Client client, List<ServiceIdDTO> services) {
        this.client = client;
        this.services = services;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ServiceIdDTO> getServices() {
        return services;
    }

    public void setServices(List<ServiceIdDTO> services) {
        this.services = services;
    }
}
