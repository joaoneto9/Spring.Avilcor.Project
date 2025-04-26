package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.ActivityResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class OrderSummaryDTO {


    private Long id;

    @JsonProperty("activities")
    private List<ActivityResponseDTO> activities;
    private BigDecimal valorTotal;
    private Instant dateBegin;
    private Instant dateFinish;

    public OrderSummaryDTO() {

    }

    public OrderSummaryDTO(Instant dateBegin, Instant dateFinish, Long id, List<ActivityResponseDTO> activities, BigDecimal valorTotal) {
        this.dateBegin = dateBegin;
        this.dateFinish = dateFinish;
        this.id = id;
        this.activities = activities;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ActivityResponseDTO> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityResponseDTO> activities) {
        this.activities = activities;
    }

    public Instant getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Instant dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Instant getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Instant dateFinish) {
        this.dateFinish = dateFinish;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
