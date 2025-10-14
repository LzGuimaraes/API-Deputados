package com.example.Deputados.Despesa;

import jakarta.persistence.*;
import lombok.*;

import com.example.Deputados.Deputado.DeputadoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
@Table(name = "despesa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DespesaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDeputado", nullable = false)
    @JsonIgnore
    private DeputadoModel deputado;

    @Temporal(TemporalType.DATE)
    private Date dataDocumento;

    private String tipoDespesa;
    private Float valorLiquido;
}
