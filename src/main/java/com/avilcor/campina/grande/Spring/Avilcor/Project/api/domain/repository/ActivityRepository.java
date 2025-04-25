package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.enums.Roupa;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.enums.Trabalho;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Optional<Activity> findByRoupaAndTrabalho(Roupa roupa, Trabalho trabalho);
}
