package com.pucminas.otre.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AtualizarEventoDto {
    private String idProdutor;
    private String idEvento;
    private Boolean status;
}
