package com.pucminas.otre.repositories;

import com.pucminas.otre.model.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, UUID> {
    Produtor findByEmailAndSenha(String email, String senha);
}
