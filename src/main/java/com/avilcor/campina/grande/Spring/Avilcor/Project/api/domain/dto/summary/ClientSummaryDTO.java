package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary;

public class ClientSummaryDTO {
    private Long id;
    private String name;
    private String email;

    public ClientSummaryDTO() {
    }

    public ClientSummaryDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
