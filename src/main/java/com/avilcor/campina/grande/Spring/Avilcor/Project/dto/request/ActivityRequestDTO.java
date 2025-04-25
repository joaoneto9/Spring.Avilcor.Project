package com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request;

import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Roupa;
import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Trabalho;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ActivityRequestDTO {

    @NotNull
    private Roupa roupa;

    @NotNull
    private Trabalho trabalho;

    @NotNull
    private BigDecimal preco;

    public ActivityRequestDTO() {

    }

    public ActivityRequestDTO(BigDecimal preco, Roupa roupa, Trabalho trabalho) {
        this.preco = preco;
        this.roupa = roupa;
        this.trabalho = trabalho;
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
