package com.paulotech.ticket_api.repository;

import com.paulotech.ticket_api.domain.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
}
