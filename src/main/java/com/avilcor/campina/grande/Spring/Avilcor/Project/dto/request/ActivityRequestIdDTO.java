package com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request;

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
