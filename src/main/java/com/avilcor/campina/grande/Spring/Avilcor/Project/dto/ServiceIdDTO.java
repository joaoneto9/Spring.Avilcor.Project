package com.avilcor.campina.grande.Spring.Avilcor.Project.dto;

import jakarta.validation.constraints.NotNull;

public class ServiceIdDTO {

    @NotNull
    private Long id;

    public ServiceIdDTO() {

    }

    public ServiceIdDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
