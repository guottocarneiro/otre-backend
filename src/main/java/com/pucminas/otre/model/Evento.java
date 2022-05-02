package com.pucminas.otre.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "evento")
@Table(name = "evento")
@Builder
public class Evento {
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String descricao;
    private String nome;
    private String data;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Artista> artistas;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingresso> ingressos;
    @ManyToOne
    private Produtor produtor;
    private Boolean ativado;
}