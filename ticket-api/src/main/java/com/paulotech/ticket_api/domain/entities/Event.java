package com.paulotech.ticket_api.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "eventos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "inicio")
    private LocalDateTime inicio;

    @Column(name = "fim")
    private LocalDateTime fim;

    @Column(name = "local", nullable = false)
    private String local;

    @Column(name = "inicio_vendas", nullable = false)
    private LocalDateTime inicioVendas;

    @Column(name = "final_vendas", nullable = false)
    private LocalDateTime finalVendas;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventStatusEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizador_id")
    private User organizador;

    @ManyToMany(mappedBy = "participantesEvents")
    private List<User> participantes = new ArrayList<>();

    @ManyToMany(mappedBy = "funcionariosEvents")
    private List<User> funcionarios = new ArrayList<>();

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<TicketType> ingressosTipo = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(nome, event.nome) && Objects.equals(inicio, event.inicio) && Objects.equals(fim, event.fim) && Objects.equals(local, event.local) && Objects.equals(inicioVendas, event.inicioVendas) && Objects.equals(finalVendas, event.finalVendas) && status == event.status && Objects.equals(createdAt, event.createdAt) && Objects.equals(updatedAt, event.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, inicio, fim, local, inicioVendas, finalVendas, status, createdAt, updatedAt);
    }
}
