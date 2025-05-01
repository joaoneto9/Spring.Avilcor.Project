package com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.DressmakerRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.OrderActivityRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.DressmakerResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.OrderActivityResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Dressmaker;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.embeddable.OrderActivity;

public class DressmakerMapper {

    public static Dressmaker toEntity(DressmakerRequestDTO dressmakerRequestDTO) {
        Dressmaker dressmaker = new Dressmaker();

        setToEntity(dressmaker, dressmakerRequestDTO);

        return dressmaker;
    }

    private static void setToEntity(Dressmaker dressmaker, DressmakerRequestDTO dressmakerRequestDTO) {
        dressmaker.setCpf(dressmakerRequestDTO.getCpf());
        dressmaker.setBaseSalary(dressmakerRequestDTO.getBaseSalary());
        dressmaker.setMaxQuantity(dressmakerRequestDTO.getMaxQuantity());
        dressmaker.setName(dressmakerRequestDTO.getName());
    }

    public static DressmakerResponseDTO toResponse(Dressmaker dressmaker) {
        DressmakerResponseDTO dressmakerResponseDTO = new DressmakerResponseDTO();

        setToResponse(dressmaker, dressmakerResponseDTO);

        return dressmakerResponseDTO;
    }

    private static void setToResponse(Dressmaker dressmaker, DressmakerResponseDTO dressmakerResponseDTO) {
        dressmakerResponseDTO.setId(dressmaker.getId());
        dressmakerResponseDTO.setOrdersActivities(dressmaker.getOrdersActivities().stream().map(DressmakerMapper::toOrderActivityResponse).toList());
        dressmakerResponseDTO.setCpf(dressmaker.getCpf());
        dressmakerResponseDTO.setBaseSalary(dressmaker.getBaseSalary());
        dressmakerResponseDTO.setMaxQuantity(dressmaker.getMaxQuantity());
        dressmakerResponseDTO.setName(dressmaker.getName());
    }

    public static OrderActivityResponseDTO toOrderActivityResponse(OrderActivity orderActivity) {
        OrderActivityResponseDTO orderActivityResponseDTO = new OrderActivityResponseDTO();

        orderActivityResponseDTO.setActivityId(orderActivity.getActivityId());
        orderActivityResponseDTO.setOrderId(orderActivity.getOrderId());

        return orderActivityResponseDTO;
    }

    public static OrderActivity toEntityOrderActivity(OrderActivityRequestDTO orderActivityRequestDTO) {
        OrderActivity orderActivity = new OrderActivity();

        orderActivity.setActivityId(orderActivityRequestDTO.getActivityId());
        orderActivity.setOrderId(orderActivityRequestDTO.getOrderId());

        return orderActivity;
    }


}
