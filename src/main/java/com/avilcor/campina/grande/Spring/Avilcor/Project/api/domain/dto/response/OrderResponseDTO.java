package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary.ClientSummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary.OrderSummaryDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class OrderResponseDTO extends OrderSummaryDTO {

    @JsonProperty("client")
    private ClientSummaryDTO client;

    public OrderResponseDTO() {

    }

    public OrderResponseDTO(ClientSummaryDTO client) {
        this.client = client;
    }

    public OrderResponseDTO(Instant dateBegin, Instant dateFinish, Long id, List<ActivityResponseDTO> activities, ClientSummaryDTO client, BigDecimal valorTotal) {
        super(dateBegin, dateFinish, id, activities, valorTotal);
        this.client = client;
    }

    public ClientSummaryDTO getClient() {
        return client;
    }

    public void setClient(ClientSummaryDTO client) {
        this.client = client;
    }
}
