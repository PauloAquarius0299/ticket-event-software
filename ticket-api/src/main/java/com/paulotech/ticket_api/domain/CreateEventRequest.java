package com.paulotech.ticket_api.domain;

import com.paulotech.ticket_api.domain.entities.EventStatusEnum;
import com.paulotech.ticket_api.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {
    private String nome;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String local;
    private LocalDateTime inicioVendas;
    private LocalDateTime finalVendas;
    private EventStatusEnum status;
    private User organizador;
    private List<CreateTicketTypeRequest> ticketTypes = new ArrayList<>();
}
