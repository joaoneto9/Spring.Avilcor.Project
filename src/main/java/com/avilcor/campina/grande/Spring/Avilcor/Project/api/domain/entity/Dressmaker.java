package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity;


import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.embeddable.OrderActivity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "tb_costureira")
public class Dressmaker implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String cpf;

    private Integer maxQuantity;

    @ElementCollection
    @CollectionTable(name = "order_activity", joinColumns = @JoinColumn(name = "costureira_id"))
    private final List<OrderActivity> ordersActivities = new ArrayList<>();

    private BigDecimal baseSalary;

    public  Dressmaker() {

    }

    public Dressmaker(BigDecimal baseSalary, String cpf, Long id, Integer maxQuantity, String name) {
        this.baseSalary = baseSalary;
        this.cpf = cpf;
        this.id = id;
        this.maxQuantity = maxQuantity;
        this.name = name;
    }

    public List<OrderActivity> getOrdersActivities() {
        return ordersActivities;
    }

    public boolean addOrderActivity(OrderActivity orderActivity) {
        if (ordersActivities.size() + 1 > maxQuantity)
            return false;

        ordersActivities.add(orderActivity);
        return true;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(Integer maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
