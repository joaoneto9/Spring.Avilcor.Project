package com.avilcor.campina.grande.Spring.Avilcor.Project.dto.summary;

import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Roupa;
import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Trabalho;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Order;
import com.avilcor.campina.grande.Spring.Avilcor.Project.service.ActivityService;

import java.math.BigDecimal;
import java.time.Instant;

public class ActivitySummaryDTO {

    private Long id;
    private Roupa roupa;
    private Trabalho trabalho;
    private BigDecimal preco;

    public ActivitySummaryDTO() {
    }

    public ActivitySummaryDTO(Long id, BigDecimal preco, Integer roupaId, Integer trabalhoId) {
        this.id = id;
        this.preco = preco;
        this.roupa = Roupa.valueOf(roupaId);
        this.trabalho = Trabalho.valueOf(trabalhoId);
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

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setRoupa(Roupa roupa) throws IllegalArgumentException{
        this.roupa = roupa;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

}
