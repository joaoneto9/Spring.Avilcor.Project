package com.avilcor.campina.grande.Spring.Avilcor.Project.repository;

import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
