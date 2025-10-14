package com.example.Deputados.Despesa.dto;

import java.util.Date;

public record DespesaRequestDTO(
    Long id,
    Long idDeputado,
    Date dataDocumento,
    String tipoDespesa,
    Float valorLiquido

) {}
