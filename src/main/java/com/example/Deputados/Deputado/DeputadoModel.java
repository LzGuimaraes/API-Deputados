package com.example.Deputados.Deputado;

import jakarta.persistence.*;
import lombok.*;

import com.example.Deputados.Despesa.DespesaModel;
import com.example.Deputados.Proposicao.ProposicaoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "deputado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeputadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCivil;

    @OneToMany(mappedBy = "deputado", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<DespesaModel> despesas;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ProposicaoModel> proposicoes;
}
