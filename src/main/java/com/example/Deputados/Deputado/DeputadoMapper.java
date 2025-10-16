package com.example.Deputados.Deputado;

import org.springframework.stereotype.Component;

import com.example.Deputados.Deputado.dto.DeputadoRequestDTO;
import com.example.Deputados.Deputado.dto.DeputadoResponseDTO;

@Component
public class DeputadoMapper {
    public DeputadoModel toModel(DeputadoRequestDTO dto) {
        DeputadoModel model = new DeputadoModel();
        model.setNomeCivil(dto.nomeCivil());
        return model;
    }

    public DeputadoResponseDTO toResponse(DeputadoModel model) {
        return new DeputadoResponseDTO(
                model.getId(),
                model.getNomeCivil(),
                model.getDespesas(),
                model.getProposicoes()
        );
    }
}
