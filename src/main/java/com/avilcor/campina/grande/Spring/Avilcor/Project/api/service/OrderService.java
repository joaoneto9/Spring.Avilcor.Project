package com.avilcor.campina.grande.Spring.Avilcor.Project.api.service;


import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.ActivityRequestIdDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.OrderRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.OrderResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Activity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Order;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller.exception.NotFoundException;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper.OrderMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Service;

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

    @Transactional
    public OrderResponseDTO save(OrderRequestDTO orderRequestDTO) {
        Order order = OrderMapper.toEntity(orderRequestDTO, activityService);

        orderRepository.save(order);

        return OrderMapper.toResponse(order);
    }

    @Transactional
    public OrderResponseDTO addActivityToOrder(ActivityRequestIdDTO activityRequestIdDTO, Long id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isEmpty())
            throw new NotFoundException("order not found");

        Activity activity = activityService.toEntity(activityRequestIdDTO);

        if (activity == null)
            throw new NotFoundException("activity not found");

        order.get().addActivity(activity);
        orderRepository.save(order.get());

        return OrderMapper.toResponse(order.get());
    }
}
