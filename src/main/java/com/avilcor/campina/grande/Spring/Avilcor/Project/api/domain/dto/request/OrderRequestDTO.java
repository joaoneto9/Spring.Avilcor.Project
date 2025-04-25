package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Client;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderRequestDTO {

    @NotNull
    private Client client;
    @NotNull
    private List<ActivityRequestIdDTO> activities;

    public OrderRequestDTO() {

    }

    public OrderRequestDTO(Client client, List<ActivityRequestIdDTO> activities) {
        this.client = client;
        this.activities = activities;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ActivityRequestIdDTO> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityRequestIdDTO> activities) {
        this.activities = activities;
    }
}
