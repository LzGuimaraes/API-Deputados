package com.example.Deputados.Proposicao;

import jakarta.persistence.*;
import lombok.*;

import com.example.Deputados.Deputado.DeputadoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "proposicao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProposicaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAutor", nullable = false)
    @JsonIgnore
    private DeputadoModel autor;

    private String siglaTipo;

    @Column(columnDefinition = "TEXT")
    private String ementa;

    private String statusDescricaoSituacao;
}
