package com.pucminas.otre.dto;

import com.pucminas.otre.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EventoDto {

    private UUID id;
    private String nome;
    private String descricao;
    private String data;
    private Endereco endereco;
    private List<Artista> artistas;
    private List<Ingresso> ingressos;
    private String idProdutor;
    private Boolean ativado;

    public Evento converter() {
        return Evento.builder().nome(nome).descricao(descricao).data(data).endereco(endereco).artistas(artistas).ingressos(ingressos).idProdutor(idProdutor).ativado(ativado).build();
    }
}
