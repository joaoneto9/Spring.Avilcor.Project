package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Dressmaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DressmakerRepository extends JpaRepository<Dressmaker, Long> {
    Optional<Dressmaker> findByCpf(String cpf);
}
