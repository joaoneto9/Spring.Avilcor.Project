package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.ActivityRequestIdDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary.ClientSummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary.OrderSummaryDTO;

import java.time.Instant;
import java.util.List;

public class OrderResponseDTO extends OrderSummaryDTO {

    private ClientSummaryDTO client;

    public OrderResponseDTO() {

    }

    public OrderResponseDTO(ClientSummaryDTO client) {
        this.client = client;
    }

    public OrderResponseDTO(Instant dateBegin, Instant dateFinish, Long id, List<ActivityRequestIdDTO> serviceIdDTOS, ClientSummaryDTO client) {
        super(dateBegin, dateFinish, id, serviceIdDTOS);
        this.client = client;
    }

    public ClientSummaryDTO getClientSummaryDTO() {
        return client;
    }

    public void setClientSummaryDTO(ClientSummaryDTO client) {
        this.client = client;
    }
}
