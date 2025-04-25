package com.avilcor.campina.grande.Spring.Avilcor.Project.repository;

import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClientEmail(String email); // busca pelo email do cliente associaod
}
