package com.example.Deputados.Votacao.dto;

import java.util.Date;
import java.util.List;

import com.example.Deputados.Voto.VotoModel;

public record VotacaoResponseDTO(
    Long id,
    Date data,
    String resumo,
    List<VotoModel> votos
) {}
