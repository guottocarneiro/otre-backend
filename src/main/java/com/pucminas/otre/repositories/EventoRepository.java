package com.pucminas.otre.repositories;

import com.pucminas.otre.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {
    List<Evento> findByIdProdutor(UUID idProdutor);

    Evento findByIdAndIdProdutor(UUID id, UUID idProdutor);
}
