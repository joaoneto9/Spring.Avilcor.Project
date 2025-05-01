package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response;

public class OrderActivityResponseDTO {

    private Long OrderId;
    private Long ActivityId;

    public OrderActivityResponseDTO() {

    }

    public OrderActivityResponseDTO(Long activityId, Long orderId) {
        ActivityId = activityId;
        OrderId = orderId;
    }

    public Long getActivityId() {
        return ActivityId;
    }

    public void setActivityId(Long activityId) {
        ActivityId = activityId;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }
}
