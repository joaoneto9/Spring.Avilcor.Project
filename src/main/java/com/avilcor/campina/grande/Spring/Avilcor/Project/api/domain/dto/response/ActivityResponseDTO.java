package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.enums.Roupa;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.enums.Trabalho;

import java.math.BigDecimal;

public class ActivityResponseDTO {

    private Long id;
    private Roupa roupa;
    private Trabalho trabalho;
    private BigDecimal preco;

    public ActivityResponseDTO() {}

    public ActivityResponseDTO(Long id, BigDecimal preco, Roupa roupa, Trabalho trabalho) {
        this.id = id;
        this.preco = preco;
        this.roupa = roupa;
        this.trabalho = trabalho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setRoupa(Roupa roupa) {
        this.roupa = roupa;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }
}
