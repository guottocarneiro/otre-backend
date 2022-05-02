package com.pucminas.otre.service;

import com.pucminas.otre.dto.AtualizarEventoDto;
import com.pucminas.otre.dto.BuscarEventoDto;
import com.pucminas.otre.dto.EventoDto;
import com.pucminas.otre.model.Evento;
import com.pucminas.otre.repositories.EventoRepository;
import com.pucminas.otre.repositories.ProdutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;
    private final ProdutorRepository produtorRepository;

    public Optional<Evento> criarEvento(EventoDto eventoDto) {
        var produtor = produtorRepository.findById(UUID.fromString(eventoDto.getIdProdutor()));
        if(produtor.isPresent()) {
            var eventoToBeCreated = eventoDto.converter(produtor.get());
            var evento = eventoRepository.save(eventoToBeCreated);
            return Optional.of(evento);
        } else {
            return Optional.empty();
        }
    }

    public EventoDto retornarEventos(BuscarEventoDto buscarEventoDto) {
        var evento = eventoRepository.findByIdAndProdutorId(UUID.fromString(buscarEventoDto.getIdEvento()), UUID.fromString(buscarEventoDto.getIdProdutor()));
        return converter(evento);
    }

    public List<EventoDto> retornarEventos() {
        List<EventoDto> listaDto = new ArrayList<>();
        var eventos = eventoRepository.findAll();
        if(eventos.isEmpty()) {
            return List.of();
        } else {
            eventos.forEach(e -> listaDto.add(converter(e)));
        }
        return listaDto;
    }

    private EventoDto converter(Evento evento) {
        return EventoDto.builder().id(evento.getId()).nome(evento.getNome()).descricao(evento.getDescricao()).data(evento.getData()).endereco(evento.getEndereco()).artistas(evento.getArtistas()).ingressos(evento.getIngressos()).idProdutor(String.valueOf(evento.getProdutor().getId())).ativado(evento.getAtivado()).build();
    }

    public List<EventoDto> retornarEventosPorProdutor(String idProdutor) {
        List<EventoDto> listaDto = new ArrayList<>();
        var eventos = eventoRepository.findByProdutorId(UUID.fromString(idProdutor));
        if(eventos.isEmpty()) {
            return List.of();
        } else {
            eventos.forEach(e -> listaDto.add(converter(e)));
        }
        return listaDto;
    }

    public void atualizarStatusEvento(AtualizarEventoDto atualizarEventoDto) {
        var evento = eventoRepository.findByIdAndProdutorId(UUID.fromString(atualizarEventoDto.getIdEvento()), UUID.fromString(atualizarEventoDto.getIdProdutor()));
        evento.setAtivado(atualizarEventoDto.getStatus());
        eventoRepository.save(evento);
    }
}
