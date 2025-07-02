package com.paulotech.ticket_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketTypeRequest {
    private String nome;
    private Double preço;
    private String descrinção;
    private Integer valorDisponivel;
}
