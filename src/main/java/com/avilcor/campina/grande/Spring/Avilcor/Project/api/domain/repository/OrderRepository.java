package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClientEmail(String email); // busca pelo email do cliente associaod
}
