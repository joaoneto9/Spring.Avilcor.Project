package com.avilcor.campina.grande.Spring.Avilcor.Project.service;


import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.OrderResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.mapper.ClientMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.mapper.OrderMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderResponseDTO> findAll() {
        return orderRepository.findAll().stream().map(OrderMapper::toResponse).toList();
    }
}
