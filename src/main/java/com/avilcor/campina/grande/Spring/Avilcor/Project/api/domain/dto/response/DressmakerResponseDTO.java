package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.dto.response;
import java.math.BigDecimal;
import java.util.List;

public class DressmakerResponseDTO {

    private Long id;
    private String name;
    private String cpf;
    private Integer maxQuantity;
    private List<OrderActivityResponseDTO> ordersActivities;
    private BigDecimal baseSalary;

    public  DressmakerResponseDTO() {

    }

    public DressmakerResponseDTO(BigDecimal baseSalary, String cpf, Long id, Integer maxQuantity, String name, List<OrderActivityResponseDTO> ordersActivities) {
        this.baseSalary = baseSalary;
        this.cpf = cpf;
        this.id = id;
        this.maxQuantity = maxQuantity;
        this.name = name;
        this.ordersActivities = ordersActivities;
    }

    public List<OrderActivityResponseDTO> getOrderActivity() {
        return ordersActivities;
    }

    public void setOrdersActivities(List<OrderActivityResponseDTO> ordersActivities) {
        this.ordersActivities = ordersActivities;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
