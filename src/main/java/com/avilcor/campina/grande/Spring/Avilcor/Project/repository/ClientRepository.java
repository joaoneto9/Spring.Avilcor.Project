package com.avilcor.campina.grande.Spring.Avilcor.Project.repository;

import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
