package com.avilcor.campina.grande.Spring.Avilcor.Project.service;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request.ActivityRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request.ActivityRequestIdDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.response.ActivityResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.mapper.ActivityMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Activity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity toEntity(ActivityRequestIdDTO activityIdDTO) {
        if (activityRepository.findById(activityIdDTO.getId()).isEmpty())
            return null;

        return activityRepository.findById(activityIdDTO.getId()).get();
    }

    public List<ActivityResponseDTO> findAll() {
        return activityRepository.findAll().stream().map(ActivityMapper::toResponse).toList();
    }

    public ResponseEntity<?> findById(Long id) {
        if (activityRepository.findById(id).isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity not found");

        return ResponseEntity.ok().body(ActivityMapper.toResponse(activityRepository.findById(id).get()));
    }

    public ResponseEntity<?> save(ActivityRequestDTO activityRequestDTO) {
        if (activityRepository.findByRoupaAndTrabalho(activityRequestDTO.getRoupa(), activityRequestDTO.getTrabalho()).isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Activity alredy Exist");

        activityRepository.save(ActivityMapper.toEntity(activityRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body("Activity has been created");
    }
}
