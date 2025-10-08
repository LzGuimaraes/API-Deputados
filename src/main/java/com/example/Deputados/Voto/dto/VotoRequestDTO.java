package com.example.Deputados.Voto.dto;

public record VotoRequestDTO(
    Long idVotacao,
    Long idDeputado,
    String voto
) {}
