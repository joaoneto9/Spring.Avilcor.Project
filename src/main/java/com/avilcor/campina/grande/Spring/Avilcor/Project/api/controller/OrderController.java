package com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.ActivityRequestIdDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.OrderRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.OrderResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.service.OrderService;
import jakarta.validation.Valid;
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
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<List<OrderResponseDTO>> findAllOrdersByClientEmail(@PathVariable String email) {
        return ResponseEntity.ok(orderService.findAllOrdersByClientEmail(email));
    }

    @PostMapping(value = "/send")
    public ResponseEntity<OrderResponseDTO> save(@RequestBody @Valid OrderRequestDTO orderRequestDTO) {
        return ResponseEntity.ok(orderService.save(orderRequestDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OrderResponseDTO> addActivityToOrder(
            @PathVariable Long id,
            @RequestBody @Valid ActivityRequestIdDTO activityRequestIdDTO
    ) {
        return ResponseEntity.ok(orderService.addActivityToOrder(activityRequestIdDTO, id));
    }


}
