package com.avilcor.campina.grande.Spring.Avilcor.Project.api.service;


import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.OrderRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.OrderResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper.OrderMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ActivityService activityService;

    public List<OrderResponseDTO> findAll() {
        return orderRepository.findAll().stream().map(OrderMapper::toResponse).toList();
    }

    public List<OrderResponseDTO> findAllOrdersByClientEmail(String email) {
        return orderRepository.findByClientEmail(email).stream().map(OrderMapper::toResponse).toList();
    }

    public ResponseEntity<String> save(OrderRequestDTO orderRequestDTO) {
        orderRepository.save(OrderMapper.toEntity(orderRequestDTO, activityService));
        return ResponseEntity.status(HttpStatus.CREATED).body("Order has been created.");
    }
}
