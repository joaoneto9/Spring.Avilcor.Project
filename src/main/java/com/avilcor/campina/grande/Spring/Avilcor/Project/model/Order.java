package com.avilcor.campina.grande.Spring.Avilcor.Project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;;
import java.util.List;

@Entity
@Table(name = "tb_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany
    @JsonIgnore
    private List<Activity> services;

    private BigDecimal valorTotal;

    public Order() {

    }

    public Order(Long id, Client client, List<Activity> services, BigDecimal valorTotal) {
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

    public List<Activity> getServices() {
        return services;
    }

    public void setServices(List<Activity> services) {
        this.services = services;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
