package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.embeddable;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class OrderActivity {

    private Long OrderId;
    private Long ActivityId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderActivity that = (OrderActivity) o;
        return Objects.equals(OrderId, that.OrderId) && Objects.equals(ActivityId, that.ActivityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(OrderId, ActivityId);
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
