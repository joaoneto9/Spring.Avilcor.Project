package com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request;

import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Roupa;
import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Trabalho;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ActivityRequestDTO {

    @NotNull
    private Integer roupa;

    @NotNull
    private Integer trabalho;

    @NotNull
    private BigDecimal preco;

    public ActivityRequestDTO() {

    }

    public ActivityRequestDTO(BigDecimal preco, Roupa roupa, Trabalho trabalho) {
        this.preco = preco;
        setRoupa(roupa);
        setTrabalho(trabalho);
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
