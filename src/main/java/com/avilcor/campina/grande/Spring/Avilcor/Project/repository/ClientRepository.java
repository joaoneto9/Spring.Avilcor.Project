package com.avilcor.campina.grande.Spring.Avilcor.Project.repository;

import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<?> findByEmail(String email);
}
