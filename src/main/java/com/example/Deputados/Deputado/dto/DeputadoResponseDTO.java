package com.example.Deputados.Deputado.dto;

import java.util.List;

import com.example.Deputados.Despesa.DespesaModel;
import com.example.Deputados.Proposicao.ProposicaoModel;

public record DeputadoResponseDTO(
    Long id,
    String nomeCivil,
    List<DespesaModel> despesas,
    List<ProposicaoModel> proposicoes
) {}
