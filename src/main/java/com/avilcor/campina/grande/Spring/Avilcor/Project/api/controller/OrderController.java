package com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.ActivityRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.OrderRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.OrderResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper.OrderMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*") // para teste
@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAll() {
        return ResponseEntity.ok(orderService.findAll().stream().map(OrderMapper::toResponse).toList());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<OrderResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(OrderMapper.toResponse(orderService.findById(id)));
    }

    @PostMapping(value = "/send")
    public ResponseEntity<OrderResponseDTO> save(@RequestBody @Valid OrderRequestDTO orderRequestDTO) {
        return ResponseEntity.ok(orderService.save(orderRequestDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OrderResponseDTO> addActivityToOrder(
            @PathVariable Long id,
            @RequestBody @Valid ActivityRequestDTO activityRequestDTO
    ) {
        return ResponseEntity.ok(orderService.addActivityToOrder(activityRequestDTO, id));
    }

    @DeleteMapping
    public ResponseEntity<List<OrderResponseDTO>> deleteAllOrdersDelivered() {
        return ResponseEntity.ok(orderService.deleteAllDelivered());
    }


}
