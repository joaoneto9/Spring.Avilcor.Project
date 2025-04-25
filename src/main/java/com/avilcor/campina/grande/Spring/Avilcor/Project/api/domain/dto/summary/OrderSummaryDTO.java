package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.ActivityRequestIdDTO;

import java.time.Instant;
import java.util.List;

public class OrderSummaryDTO {


    private Long id;
    private List<ActivityRequestIdDTO> serviceIdDTOS;
    private Instant dateBegin;
    private Instant dateFinish;

    public OrderSummaryDTO() {

    }

    public OrderSummaryDTO(Instant dateBegin, Instant dateFinish, Long id, List<ActivityRequestIdDTO> serviceIdDTOS) {
        this.dateBegin = dateBegin;
        this.dateFinish = dateFinish;
        this.id = id;
        this.serviceIdDTOS = serviceIdDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ActivityRequestIdDTO> getServiceIdDTOS() {
        return serviceIdDTOS;
    }

    public void setServiceIdDTOS(List<ActivityRequestIdDTO> serviceIdDTOS) {
        this.serviceIdDTOS = serviceIdDTOS;
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
}
