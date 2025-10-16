package com.example.Deputados.Votacao;

import jakarta.persistence.*;
import lombok.*;

import com.example.Deputados.Voto.VotoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "votacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VotacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    private String resumo;

    @OneToMany(mappedBy = "votacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<VotoModel> votos;
}
