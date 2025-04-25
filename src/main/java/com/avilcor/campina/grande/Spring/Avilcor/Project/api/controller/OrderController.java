package com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.OrderRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.OrderResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<List<OrderResponseDTO>> findAllOrdersByClientEmail(@PathVariable String email) {
        return ResponseEntity.ok().body(orderService.findAllOrdersByClientEmail(email));
    }

    @PostMapping(value = "/send")
    public ResponseEntity<String> save(@RequestBody OrderRequestDTO orderRequestDTO) {
        return orderService.save(orderRequestDTO);
    }




}
