package com.example.Deputados.Votacao.dto;

import java.util.Date;
import java.util.List;

public record VotacaoRequestDTO(
    Date data,
    String resumo,
    List<Integer> idsVotos

) {}
