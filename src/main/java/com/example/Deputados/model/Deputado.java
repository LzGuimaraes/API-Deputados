package com.example.Deputados.model;

import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "deputado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Deputado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCivil;

    @OneToMany(mappedBy = "deputado", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Despesa> despesas;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Proposicao> proposicoes;
}
