package com.avilcor.campina.grande.Spring.Avilcor.Project.api.service;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller.exception.ConflictException;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.controller.exception.NotFoundException;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.OrderActivityDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request.DressmakerRequestDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response.DressmakerResponseDTO;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Dressmaker;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.embeddable.OrderActivity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository.DressmakerRepository;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.mapper.DressmakerMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DressmakerService {

    @Autowired
    private DressmakerRepository dressmakerRepository;

    public List<Dressmaker> findAll() {
        return dressmakerRepository.findAll();
    }

    public Dressmaker findByCpf(String cpf) {
        return dressmakerRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("dressmaker with this CPF doesn't exist"));
    }

    @Transactional
    public DressmakerResponseDTO putOrderActivityDressmaker(String cpf, OrderActivity orderActivity) {
        Dressmaker dressmaker = dressmakerRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("Dressmaker with this CPF doesn't exist"));

        if (!dressmaker.addOrderActivity(orderActivity)) {
            throw new IllegalStateException("Maximum number of activities reached for this dressmaker");
        }

        return DressmakerMapper.toResponse(dressmakerRepository.save(dressmaker));
    }

    @Transactional
    public DressmakerResponseDTO save(DressmakerRequestDTO dressmakerRequestDTO) {

        if (dressmakerRepository.findByCpf(dressmakerRequestDTO.getCpf()).isPresent())
            throw new ConflictException("A dressmaker with this cpf alredy exist");

        Dressmaker dressmaker = dressmakerRepository.save(DressmakerMapper.toEntity(dressmakerRequestDTO));
        return DressmakerMapper.toResponse(dressmaker);
    }

    @Transactional
    public DressmakerResponseDTO remove(String cpf) {

        Dressmaker dressmaker = dressmakerRepository.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("dressmaker with this CPF doesn't exist"));

        DressmakerResponseDTO dressmakerResponseDTO = DressmakerMapper.toResponse(dressmaker);
        dressmakerRepository.delete(dressmaker);

        return dressmakerResponseDTO;
    }
}
