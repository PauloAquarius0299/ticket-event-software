package com.paulotech.ticket_api.service;

import com.paulotech.ticket_api.domain.CreateEventRequest;
import com.paulotech.ticket_api.domain.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizadorId, CreateEventRequest event);
}
