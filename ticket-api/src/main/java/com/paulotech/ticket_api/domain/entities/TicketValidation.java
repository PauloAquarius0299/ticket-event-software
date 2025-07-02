package com.paulotech.ticket_api.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ingressos_validação")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketValidation {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketValidationStatusEnum status;

    @Column(name = "validação_metodo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketValidationMethod validaçãoMetodo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingressos_id")
    private Ticket ingressos;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketValidation that = (TicketValidation) o;
        return Objects.equals(id, that.id) && status == that.status && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, createdAt, updatedAt);
    }
}
