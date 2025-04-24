package com.avilcor.campina.grande.Spring.Avilcor.Project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_Order")
public class Order {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JsonIgnore
    private List<Service> services;

    private BigDecimal valorTotal;

    public Order() {

    }

    public Order(Long id, Client client, List<Service> services, BigDecimal valorTotal) {
        this.client = client;
        this.id = id;
        this.valorTotal = valorTotal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
