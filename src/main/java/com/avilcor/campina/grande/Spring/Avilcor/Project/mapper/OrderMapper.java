package com.avilcor.campina.grande.Spring.Avilcor.Project.mapper;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request.OrderRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.response.OrderResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.summary.OrderSummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Activity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Order;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.summary.OrderSummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.service.ActivityService;

import java.math.BigDecimal;
import java.util.List;

public class OrderMapper {

    public static Order toEntity(OrderRequestDTO orderCreateDTO, ActivityService activityService) {
        Order order = new Order();

        setOrderEntity(orderCreateDTO, order, activityService);

        return order;
    }

    private static void setOrderEntity(OrderRequestDTO orderCreateDTO, Order order, ActivityService activityService) {

        List<Activity> lista = orderCreateDTO.getActivities().stream().map(activityService::toEntity).toList();

        order.setClient(orderCreateDTO.getClient());

        order.setServices(lista);

        order.setValorTotal(lista.stream().map(x -> x.getPreco()).reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    public static OrderSummaryDTO toSummary(Order order) {
        OrderSummaryDTO orderSummaryDTO = new OrderSummaryDTO();

        setOrderDTO(orderSummaryDTO, order);

        return orderSummaryDTO;
    }

    private static void setOrderDTO(OrderSummaryDTO orderSummaryDTO, Order order) {
        orderSummaryDTO.setId(order.getId());
        orderSummaryDTO.setServiceIdDTOS(order.getServices().stream().map(ActivityMapper::toRequestId).toList());
        orderSummaryDTO.setDateBegin(order.getDateBegin());
        orderSummaryDTO.setDateFinish(order.getDateFinish());
    }

    public static OrderResponseDTO toResponse(Order order) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        setOrderDTO(orderResponseDTO, order);
        orderResponseDTO.setClientSummaryDTO(ClientMapper.toSummary(order.getClient()));

        return orderResponseDTO;

    }
}
