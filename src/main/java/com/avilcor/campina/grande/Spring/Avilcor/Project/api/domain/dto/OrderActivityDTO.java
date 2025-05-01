package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto;

public class OrderActivityDTO {

    private Long OrderId;
    private Long ActivityId;

    public OrderActivityDTO() {
    }

    public OrderActivityDTO(Long activityId, Long orderId) {
        ActivityId = activityId;
        OrderId = orderId;
    }

    public Long getActivityId() {
        return ActivityId;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setActivityId(Long activityId) {
        ActivityId = activityId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }
}
