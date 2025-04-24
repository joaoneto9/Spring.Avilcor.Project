package com.avilcor.campina.grande.Spring.Avilcor.Project.dto;

import jakarta.validation.constraints.NotNull;

public class ActivityIdDTO {

    @NotNull
    private Long id;

    public ActivityIdDTO() {

    }

    public ActivityIdDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
