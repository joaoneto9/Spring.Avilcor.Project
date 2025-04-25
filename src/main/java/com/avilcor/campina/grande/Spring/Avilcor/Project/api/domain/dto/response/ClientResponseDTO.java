package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary.ClientSummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary.OrderSummaryDTO;

import java.util.List;

public class ClientResponseDTO extends ClientSummaryDTO {

    private List<OrderSummaryDTO> orders;

    public ClientResponseDTO() {

    }

    public ClientResponseDTO(List<OrderSummaryDTO> orders) {
        this.orders = orders;
    }

    public ClientResponseDTO(Long id, String name, String email, List<OrderSummaryDTO> orders) {
        super(id, name, email);
        this.orders = orders;
    }

    public List<OrderSummaryDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderSummaryDTO> orders) {
        this.orders = orders;
    }
}
