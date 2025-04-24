package com.avilcor.campina.grande.Spring.Avilcor.Project.dto;

import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Client;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderCreateDTO {

    @NotNull
    private Client client;
    @NotNull
    private List<ActivityIdDTO> services;

    public OrderCreateDTO() {

    }

    public OrderCreateDTO(Client client, List<ActivityIdDTO> services) {
        this.client = client;
        this.services = services;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ActivityIdDTO> getServices() {
        return services;
    }

    public void setServices(List<ActivityIdDTO> services) {
        this.services = services;
    }
}
