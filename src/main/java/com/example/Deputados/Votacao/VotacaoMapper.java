package com.example.Deputados.Votacao;

import org.springframework.stereotype.Component;

import com.example.Deputados.Votacao.dto.VotacaoRequestDTO;
import com.example.Deputados.Votacao.dto.VotacaoResponseDTO;

@Component
public class VotacaoMapper {
    public VotacaoModel toModel(VotacaoRequestDTO dto) {
        VotacaoModel model = new VotacaoModel();
        model.setData(dto.data());
        model.setResumo(dto.resumo());
        return model;
    }

    public VotacaoResponseDTO toResponse(VotacaoModel model) {
       return new VotacaoResponseDTO(
        model.getId(),
        model.getData(),
        model.getResumo(),
        model.getVotos()
       );
    }

}
