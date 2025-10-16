package com.example.Deputados.Voto;

import jakarta.persistence.*;
import lombok.*;

import com.example.Deputados.Deputado.DeputadoModel;
import com.example.Deputados.Votacao.VotacaoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "voto", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idVotacao", "idDeputado"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VotoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVotacao", nullable = false)
    @JsonIgnore
    private VotacaoModel votacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDeputado", nullable = false)
    @JsonIgnore
    private DeputadoModel deputado;

    @Column(length = 20)
    private String voto;
}
