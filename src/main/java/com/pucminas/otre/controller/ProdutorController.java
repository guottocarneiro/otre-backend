package com.pucminas.otre.controller;

import com.pucminas.otre.dto.ProdutorDto;
import com.pucminas.otre.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProdutorController.BASE_PATH)
@RequiredArgsConstructor
public class ProdutorController {

    static final String BASE_PATH = "/produtores";

    private final ProdutorService produtorService;

    @PostMapping
    public ResponseEntity criarProdutor(@RequestBody ProdutorDto produtor) {
        var produtorCriado = produtorService.criarProdutor(produtor);
        if(produtorCriado.isPresent()) {
            return ResponseEntity.of(produtorCriado);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity login(@RequestBody ProdutorDto produtor) {
        var produtorLogado = produtorService.login(produtor);
        if(produtorLogado.isPresent()) {
            return ResponseEntity.of(produtorLogado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
