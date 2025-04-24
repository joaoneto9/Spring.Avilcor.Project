package com.avilcor.campina.grande.Spring.Avilcor.Project.mapper;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.OrderCreateDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Activity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Order;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.OrderResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public class OrderMapper {

    public static Order toEntity(OrderCreateDTO orderCreateDTO) {
        Order order = new Order();

        setOrderEntity(orderCreateDTO, order);

        return order;
    }

    private static void setOrderEntity(OrderCreateDTO orderCreateDTO, Order order) {
        List<Activity> lista = orderCreateDTO.getServices().stream().map(ActivityMapper::toEntity).toList();

        order.setClient(orderCreateDTO.getClient());

        order.setServices(lista);

        order.setValorTotal(lista.stream().map(x -> x.getPreco()).reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    public static OrderResponseDTO toResponse(Order order) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        setOrderDTO(orderResponseDTO, order);

        return orderResponseDTO;
    }

    private static void setOrderDTO(OrderResponseDTO orderResponseDTO, Order order) {
        orderResponseDTO.setId(order.getId());
        orderResponseDTO.setClientResponseDTO(ClientMapper.toResponse(order.getClient()));
        orderResponseDTO.setServiceIdDTOS(order.getServices().stream().map(ActivityMapper::toId).toList());
    }

}
