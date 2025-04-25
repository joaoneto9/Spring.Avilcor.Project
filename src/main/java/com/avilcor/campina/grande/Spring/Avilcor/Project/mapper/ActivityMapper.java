package com.avilcor.campina.grande.Spring.Avilcor.Project.mapper;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request.ActivityRequestIdDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.response.ActivityResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.summary.ActivitySummaryDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Roupa;
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

    public static ActivitySummaryDTO toSummary(Activity activity) {
        ActivitySummaryDTO activitySummaryDTO = new ActivitySummaryDTO();

        setActivityDTO(activitySummaryDTO, activity);

        return activitySummaryDTO;
    }

    private static void setActivityDTO(ActivitySummaryDTO activitySummaryDTO, Activity activity) {
        activitySummaryDTO.setId(activity.getId());
        activitySummaryDTO.setPreco(activity.getPreco());
        activitySummaryDTO.setRoupa(activity.getRoupa());
        activitySummaryDTO.setTrabalho(activity.getTrabalho());
    }

    public static ActivityResponseDTO toResponse(Activity activity) {
        ActivityResponseDTO activityResponseDTO = new ActivityResponseDTO();

        setActivityDTO(activityResponseDTO, activity);
        activityResponseDTO.setOrderSummaryDTO(OrderMapper.toSummary(activity.getOrder()));

        return activityResponseDTO;
    }

}
