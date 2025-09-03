package com.example.Deputados.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;

@Entity
@Table(name = "despesa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDeputado", nullable = false)
    @JsonBackReference
    private Deputado deputado;

    @Temporal(TemporalType.DATE)
    private Date dataDocumento;

    private String tipoDespesa;
    private Float valorLiquido;
}
