package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClientEmail(String email); // busca pelo email do cliente associaod
    Optional<Order> findByDateBeginAndClientEmail(Instant dateBegin, String email);
}

