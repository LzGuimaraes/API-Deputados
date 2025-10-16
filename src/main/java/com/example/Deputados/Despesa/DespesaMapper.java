package com.example.Deputados.Despesa;

import org.springframework.stereotype.Component;

import com.example.Deputados.Despesa.dto.DespesaRequestDTO;
import com.example.Deputados.Despesa.dto.DespesaResponseDTO;

@Component
public class DespesaMapper {

    public DespesaModel toModel(DespesaRequestDTO dto) {
        DespesaModel model = new DespesaModel();
        model.setDataDocumento(dto.dataDocumento());
        model.setTipoDespesa(dto.tipoDespesa());
        model.setValorLiquido(dto.valorLiquido());
        return model;
    }

    public DespesaResponseDTO toResponse(DespesaModel model) {
        return new DespesaResponseDTO(
            model.getId(),
            model.getDeputado().getId(),
            model.getDeputado().getNomeCivil(),
            model.getDataDocumento(),
            model.getTipoDespesa(),
            model.getValorLiquido()
        );
    }
}
