package com.avilcor.campina.grande.Spring.Avilcor.Project.api.service;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller.exception.NotFoundException;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.OrderActivityRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.DressmakerResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Dressmaker;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.embeddable.OrderActivity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository.DressmakerRepository;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper.DressmakerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DressmakerService {

    @Autowired
    private DressmakerRepository dressmakerRepository;

    public List<Dressmaker> findAll() {
        return dressmakerRepository.findAll();
    }

    public DressmakerResponseDTO putOrderActivityDressmaker(String cpf, OrderActivityRequestDTO orderActivityRequestDTO) {
        Dressmaker dressmaker = dressmakerRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("Dressmaker with this CPF doesn't exist"));

        OrderActivity orderActivity = DressmakerMapper.toEntityOrderActivity(orderActivityRequestDTO);

        if (!dressmaker.addOrderActivity(orderActivity)) {
            throw new IllegalStateException("Maximum number of activities reached for this dressmaker");
        }

        return DressmakerMapper.toResponse(dressmakerRepository.save(dressmaker));
    }
}
