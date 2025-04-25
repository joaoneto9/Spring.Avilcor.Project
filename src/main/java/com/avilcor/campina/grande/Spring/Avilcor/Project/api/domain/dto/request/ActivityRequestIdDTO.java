package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request;

import jakarta.validation.constraints.NotNull;

public class ActivityRequestIdDTO {

    @NotNull
    private Long id;

    public ActivityRequestIdDTO() {

    }

    public ActivityRequestIdDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
