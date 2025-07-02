package com.paulotech.ticket_api.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketTypeRequestDTO {

    @NotBlank(message = "O noem desse ser requisito")
    private String nome;

    @NotNull(message = "Preço é requisito")
    @PositiveOrZero(message = "Preço deve ser zero ou maior")
    private Double preço;

    private String descrinção;

    private String totalDisponivel;
}
