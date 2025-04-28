package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderRequestDTO {

    @NotNull
    private String clientEmail;
    @NotNull
    private List<ActivityRequestDTO> activities;

    public OrderRequestDTO() {

    }

    public OrderRequestDTO(String clientEmail, List<ActivityRequestDTO> activities) {
        this.clientEmail = clientEmail;
        this.activities = activities;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public List<ActivityRequestDTO> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityRequestDTO> activities) {
        this.activities = activities;
    }
}
