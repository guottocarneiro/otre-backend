package com.pucminas.otre.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ingresso")
@Table(name = "ingresso")
public class Ingresso {
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
    @ManyToOne
    private Evento evento;
}
