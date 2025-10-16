package com.example.Deputados.Proposicao.dto;

public record ProposicaoResponseDTO(
    Long id,
    Long idAutor,
    String siglaTipo,
    String ementa,
    String statusDescricaoSituacao
) {}
