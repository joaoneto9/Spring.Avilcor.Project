package com.avilcor.campina.grande.Spring.Avilcor.Project.dto;

import java.util.List;

public class ClientResponseDTO {

    private Long id;
    private String name;
    private String email;
    private List<OrderResponseDTO> orders;

    public ClientResponseDTO(Long id, String name, String email, List<OrderResponseDTO> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.orders = orders;
    }

    public List<OrderResponseDTO> getOrders() {
        return orders;
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
