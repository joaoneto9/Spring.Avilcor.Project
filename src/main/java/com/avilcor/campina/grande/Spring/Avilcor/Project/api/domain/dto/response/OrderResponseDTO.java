package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary.ClientSummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary.OrderSummaryDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class OrderResponseDTO extends OrderSummaryDTO {

    @JsonProperty("clientEmail")
    private String clientEmail;

    public OrderResponseDTO() {

    }

    public OrderResponseDTO(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public OrderResponseDTO(Instant dateBegin, Instant dateFinish, Long id, List<ActivityResponseDTO> activities, String clientEmail, BigDecimal valorTotal) {
        super(dateBegin, dateFinish, id, activities, valorTotal);
        this.clientEmail = clientEmail;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
}
