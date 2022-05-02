package com.pucminas.otre.controller;

import com.pucminas.otre.dto.AtualizarEventoDto;
import com.pucminas.otre.dto.BuscarEventoDto;
import com.pucminas.otre.dto.EventoDto;
import com.pucminas.otre.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EventoController.BASE_PATH)
@RequiredArgsConstructor
public class EventoController {
    static final String BASE_PATH = "/eventos";

    private final EventoService eventoService;

    @PostMapping
    public ResponseEntity criarEvento(@RequestBody EventoDto evento){
        var eventoCriado = eventoService.criarEvento(evento);
        if(eventoCriado.isPresent()) {
            return ResponseEntity.ok("Evento criado com sucesso!");
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

//    @GetMapping
//    public ResponseEntity retornarEventos() {
//        return ResponseEntity.ok(eventoService.retornarEventos());
//    }

    @GetMapping(path = "/{idProdutor}")
    public ResponseEntity retornarEventosDoProdutor(@PathVariable String idProdutor) {
        try {
            return ResponseEntity.ok(eventoService.retornarEventosPorProdutor(idProdutor));
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity retornarEventos(@RequestBody BuscarEventoDto buscarEventoDto) {
        try {
            return ResponseEntity.ok(eventoService.retornarEventos(buscarEventoDto));
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity atualizarStatus(@RequestBody AtualizarEventoDto atualizarEventoDto) {
        eventoService.atualizarStatusEvento(atualizarEventoDto);
        return ResponseEntity.ok("Evento atualizado!");
    }
}
