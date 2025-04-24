package com.avilcor.campina.grande.Spring.Avilcor.Project.service;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.ActivityIdDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Activity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity toEntity(ActivityIdDTO activityIdDTO) {
        if (activityRepository.findById(activityIdDTO.getId()).isEmpty())
            return null;

        return activityRepository.findById(activityIdDTO.getId()).get();
    }

}
