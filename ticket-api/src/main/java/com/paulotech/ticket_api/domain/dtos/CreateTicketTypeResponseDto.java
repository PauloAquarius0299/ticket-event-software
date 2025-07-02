package com.paulotech.ticket_api.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketTypeResponseDto {
    private UUID id;
    private String nome;
    private Double preço;
    private String descrinção;
    private Integer disponivelTotal;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
