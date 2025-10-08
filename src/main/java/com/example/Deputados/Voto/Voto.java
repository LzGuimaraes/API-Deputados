package com.example.Deputados.Voto;

import jakarta.persistence.*;
import lombok.*;

import com.example.Deputados.Deputado.DeputadoModel;
import com.example.Deputados.Votacao.Votacao;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "voto", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idVotacao", "idDeputado"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVotacao", nullable = false)
    @JsonBackReference
    private Votacao votacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDeputado", nullable = false)
    private DeputadoModel deputado;

    @Column(length = 20)
    private String voto;
}
