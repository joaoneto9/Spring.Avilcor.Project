package com.avilcor.campina.grande.Spring.Avilcor.Project.api.service;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.ActivityRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.ActivityResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller.exception.ConflictException;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller.exception.NotFoundException;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.enums.Roupa;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.enums.Trabalho;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper.ActivityMapper;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Activity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository.ActivityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Activity findById(Long id) {
        Optional<Activity> activity = activityRepository.findById(id);
        return activity.orElseThrow(() -> new NotFoundException("activity not found"));
    }

    public Activity findByRoupaAndTrabalho(Roupa roupa, Trabalho trabalho) {
        Optional<Activity> activity = activityRepository.findByRoupaAndTrabalho(roupa, trabalho);
        return activity.orElseThrow(() -> new NotFoundException("activity not found"));
    }

    @Transactional
    public ActivityResponseDTO save(ActivityRequestDTO activityRequestDTO) {
        if (activityRepository.findByRoupaAndTrabalho(activityRequestDTO.getRoupa(), activityRequestDTO.getTrabalho()).isPresent())
            throw new ConflictException("Activity alredy exists");

        Activity activity = ActivityMapper.toEntity(activityRequestDTO);
        activityRepository.save(activity);
        return ActivityMapper.toResponse(activity);

    }

}
