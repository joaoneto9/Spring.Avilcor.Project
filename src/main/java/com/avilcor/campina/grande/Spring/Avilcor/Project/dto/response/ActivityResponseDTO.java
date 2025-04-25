package com.avilcor.campina.grande.Spring.Avilcor.Project.dto.response;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.summary.ActivitySummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.summary.OrderSummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Order;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class ActivityResponseDTO extends ActivitySummaryDTO {

    private OrderSummaryDTO order;

    public ActivityResponseDTO() {

    }

    public ActivityResponseDTO(OrderSummaryDTO order) {
        this.order = order;
    }

    public ActivityResponseDTO(Long id, BigDecimal preco, Integer roupaId, Integer trabalhoId, OrderSummaryDTO order) {
        super(id, preco, roupaId, trabalhoId);
        this.order = order;
    }

    public OrderSummaryDTO getOrderSummaryDTO() {
        return order;
    }

    public void setOrderSummaryDTO(OrderSummaryDTO order) {
        this.order = order;
    }
}
