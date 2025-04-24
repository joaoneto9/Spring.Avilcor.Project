package com.avilcor.campina.grande.Spring.Avilcor.Project.dto.response;

import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Roupa;
import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Trabalho;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Order;
import jakarta.persistence.*;

import java.math.BigDecimal;

public class ActivityResponseDTO {

    private Long id;
    private Roupa roupa;
    private Trabalho trabalho;
    private BigDecimal preco;
    private Order order;

    public ActivityResponseDTO() {
    }

    public ActivityResponseDTO(Long id, Order order, BigDecimal preco, Integer roupaId, Integer trabalhoId) {
        this.id = id;
        this.order = order;
        this.preco = preco;
        setRoupa(roupaId);
        setTrabalho(trabalhoId);
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
        return roupa;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setRoupa(Integer code) throws IllegalArgumentException{
        this.roupa = Roupa.valueOf(code);
    }

    public void setTrabalho(Integer code) {
        this.trabalho = Trabalho.valueOf(code);
    }

}
