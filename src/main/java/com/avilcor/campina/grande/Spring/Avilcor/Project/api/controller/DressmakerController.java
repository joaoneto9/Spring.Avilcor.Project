package com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.OrderActivityDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.DressmakerRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.DressmakerResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Dressmaker;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.embeddable.OrderActivity;
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

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<DressmakerResponseDTO> findByCpf( @PathVariable String cpf ) {
        return ResponseEntity.ok(DressmakerMapper.toResponse(dressmakerService.findByCpf(cpf)));
    }

    @PostMapping("/post/dressmaker")
    public ResponseEntity<DressmakerResponseDTO> saveDressmaker( @RequestBody DressmakerRequestDTO dressmakerRequestDTO ) {
        return ResponseEntity.ok(dressmakerService.save(dressmakerRequestDTO));
    }

    @PutMapping("/put/order/activity/{cpf}")
    public ResponseEntity<DressmakerResponseDTO> putOrderActivity(
            @PathVariable String cpf,
            @RequestBody OrderActivity orderActivity) {

        return ResponseEntity.ok(dressmakerService.putOrderActivityDressmaker(cpf, orderActivity));
    }

    @DeleteMapping("delete/{cpf}")
    public ResponseEntity<DressmakerResponseDTO> deleteDressmaker( @PathVariable String cpf) {
        return ResponseEntity.ok(dressmakerService.remove(cpf));
    }

}
