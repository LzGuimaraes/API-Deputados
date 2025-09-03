package com.example.Deputados.model;

import jakarta.persistence.*;
import lombok.*;
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
    private Deputado deputado;

    @Column(length = 20)
    private String voto;
}
