package com.avilcor.campina.grande.Spring.Avilcor.Project.mapper;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.ActivityIdDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Activity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.service.ActivityService;

public class ServiceMapper {

    public static Activity toEntity(ActivityIdDTO activityIdDTO) {
        ActivityService activityService = new ActivityService();

        return activityService.toEntity(activityIdDTO);
    }

    public static ActivityIdDTO toId(Activity service) {
        ActivityIdDTO serviceIdDTO = new ActivityIdDTO();

        serviceIdDTO.setId(service.getId());

        return  serviceIdDTO;
    }

}
