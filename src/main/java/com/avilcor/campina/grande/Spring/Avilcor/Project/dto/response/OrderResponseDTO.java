package com.avilcor.campina.grande.Spring.Avilcor.Project.dto.response;

import com.avilcor.campina.grande.Spring.Avilcor.Project.dto.request.ActivityRequestIdDTO;

import java.util.List;

public class OrderResponseDTO {

    private Long id;
    private List<ActivityRequestIdDTO> serviceIdDTOS;
    private ClientResponseDTO clientResponseDTO;

    public OrderResponseDTO() {

    }

    public OrderResponseDTO(ClientResponseDTO clientResponseDTO, Long id, List<ActivityRequestIdDTO> serviceIdDTOS) {
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

    public List<ActivityRequestIdDTO> getServiceIdDTOS() {
        return serviceIdDTOS;
    }

    public void setServiceIdDTOS(List<ActivityRequestIdDTO> serviceIdDTOS) {
        this.serviceIdDTOS = serviceIdDTOS;
    }
}
