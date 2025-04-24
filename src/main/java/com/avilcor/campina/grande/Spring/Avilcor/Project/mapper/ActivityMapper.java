package com.avilcor.campina.grande.Spring.Avilcor.Project.mapper;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request.ActivityRequestIdDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Activity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.service.ActivityService;

public class ActivityMapper {

    public static Activity toEntity(ActivityRequestIdDTO activityIdDTO) {
        ActivityService activityService = new ActivityService();

        return activityService.toEntity(activityIdDTO);
    }

    public static ActivityRequestIdDTO toRequestId(Activity service) {
        ActivityRequestIdDTO serviceIdDTO = new ActivityRequestIdDTO();

        serviceIdDTO.setId(service.getId());

        return  serviceIdDTO;
    }

}
