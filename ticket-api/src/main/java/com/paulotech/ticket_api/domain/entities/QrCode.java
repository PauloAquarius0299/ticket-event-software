package com.paulotech.ticket_api.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "qr_codes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QrCode {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private QrCodeStatusEnum status;

    @Column(name = "valor", nullable = false)
    private String valor;

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
        QrCode qrCode = (QrCode) o;
        return Objects.equals(id, qrCode.id) && status == qrCode.status && Objects.equals(valor, qrCode.valor) && Objects.equals(createdAt, qrCode.createdAt) && Objects.equals(updatedAt, qrCode.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, valor, createdAt, updatedAt);
    }
}
