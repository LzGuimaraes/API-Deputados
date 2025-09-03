package com.example.Deputados.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "proposicao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proposicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAutor", nullable = false)
    @JsonBackReference
    private Deputado autor;

    private String siglaTipo;

    @Column(columnDefinition = "TEXT")
    private String ementa;

    private String statusDescricaoSituacao;
}
