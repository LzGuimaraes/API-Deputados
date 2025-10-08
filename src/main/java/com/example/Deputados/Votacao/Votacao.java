package com.example.Deputados.Votacao;

import jakarta.persistence.*;
import lombok.*;

import com.example.Deputados.Voto.Voto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "votacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Votacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    private String resumo;

    @OneToMany(mappedBy = "votacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Voto> votos;
}
