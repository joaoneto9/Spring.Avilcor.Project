package com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.ActivityRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.ActivityRequestIdDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.ActivityResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.model.Activity;

public class ActivityMapper {

    public static Activity toEntity(ActivityRequestDTO activityRequestDTO) {
        Activity activity = new Activity();

        setActivityEntity(activityRequestDTO, activity);

        return activity;
    }

    private static void setActivityEntity(ActivityRequestDTO activityRequestDTO, Activity activity) {
        activity.setPreco(activityRequestDTO.getPreco());
        activity.setRoupa(activityRequestDTO.getRoupa());
        activity.setTrabalho(activityRequestDTO.getTrabalho());
    }

    public static ActivityRequestIdDTO toRequestId(Activity service) {
        ActivityRequestIdDTO serviceIdDTO = new ActivityRequestIdDTO();

        serviceIdDTO.setId(service.getId());

        return  serviceIdDTO;
    }

    public static ActivityResponseDTO toSummary(Activity activity) {
        ActivityResponseDTO activitySummaryDTO = new ActivityResponseDTO();

        setActivityDTO(activitySummaryDTO, activity);

        return activitySummaryDTO;
    }

    private static void setActivityDTO(ActivityResponseDTO activitySummaryDTO, Activity activity) {
        activitySummaryDTO.setId(activity.getId());
        activitySummaryDTO.setPreco(activity.getPreco());
        activitySummaryDTO.setRoupa(activity.getRoupa());
        activitySummaryDTO.setTrabalho(activity.getTrabalho());
    }

    public static ActivityResponseDTO toResponse(Activity activity) {
        ActivityResponseDTO activityResponseDTO = new ActivityResponseDTO();

        setActivityDTO(activityResponseDTO, activity);

        return activityResponseDTO;
    }

}
