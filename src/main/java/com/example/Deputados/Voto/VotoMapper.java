package com.example.Deputados.Voto;

import org.springframework.stereotype.Component;

import com.example.Deputados.Voto.dto.VotoRequestDTO;
import com.example.Deputados.Voto.dto.VotoResponseDTO;

@Component
public class VotoMapper {
    public VotoModel toModel(VotoRequestDTO dto) {
        VotoModel model = new VotoModel();
        model.setVoto(dto.voto());
        return model;
    }
    
    public VotoResponseDTO toResponse(VotoModel model) {
        return new VotoResponseDTO(
            model.getId(),
            model.getVotacao().getId(),
            model.getDeputado().getId(),
            model.getVoto()
        );
    }
}
