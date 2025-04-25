package com.avilcor.campina.grande.Spring.Avilcor.Project.api.service;


import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.OrderRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.OrderResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Activity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Order;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper.OrderMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<?> addActivityToOrder(Long activityId, String emailClient, Instant dateBeginOrder) {
        Optional<Order> order = orderRepository.findByDateBeginAndClientEmail(dateBeginOrder, emailClient);

        if (order.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order nao Registrada nessa data ou por esse Cliente");

        Activity activity = activityService.findById(activityId);

        if (activity == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity nao encontrada, id invalido");

        order.get().addActivity(activity);
        orderRepository.save(order.get());
        return ResponseEntity.status(HttpStatus.OK).body("Actividade adicionada na Order.");
    }
}
