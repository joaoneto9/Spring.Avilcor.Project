package com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.OrderRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.OrderResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.summary.OrderSummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Activity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Order;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository.ActivityRepository;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository.ClientRepository;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.service.ActivityService;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.service.ClientService;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class OrderMapper {

    public static Order toEntity(OrderRequestDTO orderRequestDTO, ClientService clientService, ActivityService activityService) {
        Order order = new Order();

        order.setClient(clientService.findByEmail(orderRequestDTO.getClientEmail()));
        order.setServices(orderRequestDTO.getActivities().stream()
                .map(x -> activityService.findByRoupaAndTrabalho(x.getRoupa(), x.getTrabalho()))
                .toList());
        order.updateValue();

        return order;
    }


    public static OrderSummaryDTO toSummary(Order order) {
        OrderSummaryDTO orderSummaryDTO = new OrderSummaryDTO();

        setOrderDTO(orderSummaryDTO, order);

        return orderSummaryDTO;
    }

    private static void setOrderDTO(OrderSummaryDTO orderSummaryDTO, Order order) {
        orderSummaryDTO.setId(order.getId());
        orderSummaryDTO.setActivities(order.getServices().stream().map(ActivityMapper::toResponse).toList());
        orderSummaryDTO.setValorTotal(order.getValorTotal());
        orderSummaryDTO.setDateBegin(order.getDateBegin());
        orderSummaryDTO.setDateFinish(order.getDateFinish());
    }

    public static OrderResponseDTO toResponse(Order order) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        setOrderDTO(orderResponseDTO, order);
        orderResponseDTO.setClient(ClientMapper.toSummary(order.getClient()));

        return orderResponseDTO;

    }
}
