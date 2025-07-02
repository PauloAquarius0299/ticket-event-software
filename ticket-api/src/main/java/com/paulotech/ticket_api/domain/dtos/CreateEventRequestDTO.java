package com.paulotech.ticket_api.domain.dtos;

import com.paulotech.ticket_api.domain.entities.EventStatusEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequestDTO {

    @NotBlank(message = "Nome do evento é requisito")
    private String nome;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    @NotBlank(message = "Informação local é requisito")
    private String local;

    private LocalDateTime vendasInicio;

    private LocalDateTime vendasFim;

    @NotNull(message = "Status do evento deve ser fornecido")
    private EventStatusEnum status;

    @NotEmpty(message = "É necessário pelo menos um tipo de bilhete")
    @Valid
    private List<CreateTicketTypeRequestDTO> ticketTypes;
}
