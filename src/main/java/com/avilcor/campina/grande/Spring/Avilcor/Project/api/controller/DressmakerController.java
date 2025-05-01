package com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.OrderActivityRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.DressmakerResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper.DressmakerMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.service.DressmakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dressmakers")
public class DressmakerController {

    @Autowired
    private DressmakerService dressmakerService;

    @GetMapping
    public ResponseEntity<List<DressmakerResponseDTO>> findAll() {
        return ResponseEntity.ok(dressmakerService.findAll()
                .stream()
                .map(DressmakerMapper::toResponse).toList());
    }

    @PutMapping("/put/order/activity/{cpf}")
    public ResponseEntity<DressmakerResponseDTO> putOrderActivity(
            @PathVariable String cpf,
            @RequestBody OrderActivityRequestDTO orderActivityRequestDTO) {

        return ResponseEntity.ok(dressmakerService.putOrderActivityDressmaker(cpf, orderActivityRequestDTO));
    }
}
