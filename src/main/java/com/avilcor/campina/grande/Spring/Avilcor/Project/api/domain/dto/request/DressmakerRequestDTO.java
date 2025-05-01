package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public class DressmakerRequestDTO {

    @NotBlank
    private String name;

    @CPF
    @NotBlank
    private String cpf;

    @NotNull
    private Integer maxQuantity;

    @NotNull
    private BigDecimal baseSalary;

    public DressmakerRequestDTO() {

    }

    public DressmakerRequestDTO(BigDecimal baseSalary, String cpf, Integer maxQuantity, String name) {
        this.baseSalary = baseSalary;
        this.cpf = cpf;
        this.maxQuantity = maxQuantity;
        this.name = name;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(Integer maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
