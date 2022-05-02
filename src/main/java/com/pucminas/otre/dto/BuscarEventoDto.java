package com.pucminas.otre.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuscarEventoDto {
    private String idProdutor;
    private String idEvento;
}
