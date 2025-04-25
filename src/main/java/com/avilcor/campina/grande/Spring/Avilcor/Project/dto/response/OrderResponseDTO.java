package com.avilcor.campina.grande.Spring.Avilcor.Project.dto.response;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request.ActivityRequestIdDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.summary.ClientSummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.summary.OrderSummaryDTO;

import java.time.Instant;
import java.util.List;

public class OrderResponseDTO extends OrderSummaryDTO {

    private ClientSummaryDTO clientSummaryDTO;

    public OrderResponseDTO() {

    }

    public OrderResponseDTO(ClientSummaryDTO clientSummaryDTO) {
        this.clientSummaryDTO = clientSummaryDTO;
    }

    public OrderResponseDTO(Instant dateBegin, Instant dateFinish, Long id, List<ActivityRequestIdDTO> serviceIdDTOS, ClientSummaryDTO clientSummaryDTO) {
        super(dateBegin, dateFinish, id, serviceIdDTOS);
        this.clientSummaryDTO = clientSummaryDTO;
    }

    public ClientSummaryDTO getClientSummaryDTO() {
        return clientSummaryDTO;
    }

    public void setClientSummaryDTO(ClientSummaryDTO clientSummaryDTO) {
        this.clientSummaryDTO = clientSummaryDTO;
    }
}
