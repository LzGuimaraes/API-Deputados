package com.example.Deputados.Proposicao;

import org.springframework.stereotype.Component;

import com.example.Deputados.Proposicao.dto.ProposicaoRequestDTO;
import com.example.Deputados.Proposicao.dto.ProposicaoResponseDTO;

@Component
public class ProposicaoMapper {

    public ProposicaoModel toModel(ProposicaoRequestDTO dto) {
        ProposicaoModel model = new ProposicaoModel();
        model.setSiglaTipo(dto.siglaTipo());
        model.setEmenta(dto.ementa());
        model.setStatusDescricaoSituacao(dto.statusDescricaoSituacao());
        return model;
    }

    public ProposicaoResponseDTO toResponse(ProposicaoModel model) {
        return new ProposicaoResponseDTO(
            model.getId(),
            model.getAutor().getId(),
            model.getSiglaTipo(),
            model.getEmenta(),
            model.getStatusDescricaoSituacao()
        );
    }
}