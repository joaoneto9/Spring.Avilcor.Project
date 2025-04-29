package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

