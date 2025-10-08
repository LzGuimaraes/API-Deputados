package com.example.Deputados.Voto;

import org.springframework.stereotype.Component;

import com.example.Deputados.Deputado.DeputadoModel;
import com.example.Deputados.Votacao.VotacaoModel;
import com.example.Deputados.Voto.dto.VotoResponseDTO;

@Component
public class VotoMapper {
    public VotoModel toModel(VotoResponseDTO dto, DeputadoModel deputado, VotacaoModel votacao) {
        VotoModel model = new VotoModel();
        model.setDeputado(deputado);
        model.setVotacao(votacao);
        model.setVoto(dto.voto());
        return model;
    }
    public VotoResponseDTO toResponse(VotoModel model) {
        return new VotoResponseDTO(
            model.getId(),
            model.getVotacao().getId(),
            model.getVotacao().getituloVotacao(),
            model.getDeputado().getId(),
            model.getDeputado().getNomeCivil(), 
            model.getVoto()
        );
    }
}
