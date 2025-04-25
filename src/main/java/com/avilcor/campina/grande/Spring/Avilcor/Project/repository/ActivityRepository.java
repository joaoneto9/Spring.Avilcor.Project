package com.avilcor.campina.grande.Spring.Avilcor.Project.repository;

import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Roupa;
import com.avilcor.campina.grande.Spring.Avilcor.Project.enums.Trabalho;
import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Optional<Activity> findByRoupaAndTrabalho(Roupa roupa, Trabalho trabalho);
}
