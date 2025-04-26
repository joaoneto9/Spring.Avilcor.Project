package com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.ActivityRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.ActivityResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Activity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper.ActivityMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.service.ActivityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public ResponseEntity<List<ActivityResponseDTO>> findAll() {
        return ResponseEntity.ok().body(activityService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ActivityResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(activityService.findById(id));
    }

    @PostMapping(value = "/send")
    public ResponseEntity<ActivityResponseDTO> save(@RequestBody @Valid ActivityRequestDTO activityRequestDTO) {
        return ResponseEntity.ok(activityService.save(activityRequestDTO));
    }

}
