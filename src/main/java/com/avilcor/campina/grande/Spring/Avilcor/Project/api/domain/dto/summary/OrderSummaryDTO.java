package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.ActivityResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderSummaryDTO {


    private Long id;

    @JsonProperty("activities")
    private List<ActivityResponseDTO> activities;
    private BigDecimal valorTotal;
    private String dateBegin;
    private String dateFinish;

    public OrderSummaryDTO() {

    }

    public OrderSummaryDTO(Instant dateBegin, Instant dateFinish, Long id, List<ActivityResponseDTO> activities, BigDecimal valorTotal) {
        setDateBegin(dateBegin);
        setDateFinish(dateFinish);
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

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Instant dateBegin) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd/MM/yyyy HH:mm:ss") // formato padrao
                .withZone(ZoneId.systemDefault()); // "Z" -> inglaterra

        this.dateBegin = formatter.format(dateBegin);
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Instant dateFinish) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd/MM/yyyy HH:mm:ss") // formato padrao
                .withZone(ZoneId.systemDefault()); // "Z" -> inglaterra

        this.dateFinish = formatter.format(dateFinish);
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
