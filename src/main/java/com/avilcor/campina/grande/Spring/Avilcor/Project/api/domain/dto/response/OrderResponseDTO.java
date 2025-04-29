package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary.ClientSummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary.OrderSummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.enums.StatusOrder;
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

    public OrderResponseDTO(Instant dateBegin, Instant dateFinish, Long id, List<ActivityResponseDTO> activities, String clientEmail, BigDecimal valorTotal, StatusOrder statusOrder) {
        super(dateBegin, dateFinish, id, activities, valorTotal, statusOrder);
        this.clientEmail = clientEmail;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
}
