package com.pucminas.otre.dto;

import com.pucminas.otre.model.Produtor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutorDto {
    private String email;
    private String senha;

    public Produtor converter() {
        return Produtor.builder().email(email).senha(senha).build();
    }
}
