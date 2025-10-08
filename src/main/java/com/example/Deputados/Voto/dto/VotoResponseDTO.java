package com.example.Deputados.Voto.dto;

public record VotoResponseDTO(
    Long id,
    Long idVotacao,
    String tituloVotacao,
    Long idDeputado,
    String nomeDeputado,
    String voto
) {}
