package com.example.Deputados.Proposicao.dto;

public record ProposicaoRequestDTO(
    Long idAuthor,
    String siglaTipo,
    String ementa,
    String statusDescricaoSituacao
) {}
