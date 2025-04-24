package com.avilcor.campina.grande.Spring.Avilcor.Project.model;

import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Roupa;
import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Trabalho;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Service {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer roupa;
    private Integer trabalho;
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "order-id")
    private Order order;

    public Service() {

    }

    public Service(Long id, Order order, BigDecimal preco, Roupa roupa, Trabalho trabalho) {
        this.id = id;
        this.order = order;
        this.preco = preco;
        this.roupa = roupa.getCode();
        this.trabalho = trabalho.getCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Roupa getRoupa() {
        return Roupa.valueOf(roupa);
    }

    public void setRoupa(Roupa roupa) {
        if (roupa != null)
            this.roupa = roupa.getCode();
    }

    public Trabalho getTrabalho() {
        return Trabalho.valueOf(trabalho);
    }

    public void setTrabalho(Trabalho trabalho) {
        if (trabalho != null)
            this.trabalho = trabalho.getCode();
    }
}
