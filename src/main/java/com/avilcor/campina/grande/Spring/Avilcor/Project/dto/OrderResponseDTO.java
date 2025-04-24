package com.avilcor.campina.grande.Spring.Avilcor.Project.dto;

import java.util.List;

public class OrderResponseDTO {

    private Long id;
    private List<ActivityIdDTO> serviceIdDTOS;
    private ClientResponseDTO clientResponseDTO;

    public OrderResponseDTO() {

    }

    public OrderResponseDTO(ClientResponseDTO clientResponseDTO, Long id, List<ActivityIdDTO> serviceIdDTOS) {
        this.clientResponseDTO = clientResponseDTO;
        this.id = id;
        this.serviceIdDTOS = serviceIdDTOS;
    }

    public ClientResponseDTO getClientResponseDTO() {
        return clientResponseDTO;
    }

    public void setClientResponseDTO(ClientResponseDTO clientResponseDTO) {
        this.clientResponseDTO = clientResponseDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ActivityIdDTO> getServiceIdDTOS() {
        return serviceIdDTOS;
    }

    public void setServiceIdDTOS(List<ActivityIdDTO> serviceIdDTOS) {
        this.serviceIdDTOS = serviceIdDTOS;
    }
}
