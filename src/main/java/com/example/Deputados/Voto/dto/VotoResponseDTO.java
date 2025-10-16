package com.example.Deputados.Voto.dto;

public record VotoResponseDTO(
    Long id,
    Long idVotacao,
    Long idDeputado,
    String voto
) {}
