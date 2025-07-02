package com.paulotech.ticket_api.domain.dtos;

import com.paulotech.ticket_api.domain.entities.EventStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEventResponseDto {
    private UUID id;
    private String nome;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String local;
    private LocalDateTime vendasInicio;
    private LocalDateTime vendasFim;
    private EventStatusEnum status;
    private List<CreateTicketTypeRequestDTO> ticketTypes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
