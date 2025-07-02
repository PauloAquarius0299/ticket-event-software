package com.paulotech.ticket_api.service.impl;

import com.paulotech.ticket_api.domain.CreateEventRequest;
import com.paulotech.ticket_api.domain.entities.Event;
import com.paulotech.ticket_api.domain.entities.TicketType;
import com.paulotech.ticket_api.domain.entities.User;
import com.paulotech.ticket_api.exceptions.UserNotFoundException;
import com.paulotech.ticket_api.repository.UserRepository;
import com.paulotech.ticket_api.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;

    @Override
    public Event createEvent(UUID organizadorId, CreateEventRequest event) {
        User organizador = userRepository.findById(organizadorId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with ID '%s'not found",
                        organizadorId))
                );

        List<TicketType> ticketTypesToCreate = event.getTicketTypes().stream().map(ticketType -> {
            TicketType ticketTypeToCreate = new TicketType();
            ticketTypeToCreate.setNome(ticketType.getNome());
            ticketTypeToCreate.setPreço(ticketType.getPreço());
            ticketTypeToCreate.setDescrinção(ticketType.getDescrinção());
            ticketTypeToCreate.setTotalDisponivel(ticketType.getValorDisponivel());
            return ticketTypeToCreate;
        }).toList();

        Event eventToCreate = new Event();
        eventToCreate.setNome(event.getNome());
        eventToCreate.setInicio(event.getInicio());
        eventToCreate.setFim(event.getFim());
        eventToCreate.setLocal(event.getLocal());
        eventToCreate.setInicioVendas(event.getInicioVendas());
        eventToCreate.setFinalVendas(event.getFinalVendas());
        eventToCreate.setStatus(event.getStatus());
        eventToCreate.setOrganizador(organizador);
        eventToCreate.setIngressosTipo(ticketTypesToCreate);
        return null;
    }
}
