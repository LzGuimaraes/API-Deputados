package com.example.Deputados.Despesa.dto;

import java.util.Date;

public record DespesaResponseDTO(
    Long id,
    Long idDeputado,
    String nomeDeputado,
    Date dataDocumento,
    String tipoDespesa,
    Float valorLiquido

) {}
