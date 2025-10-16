package com.example.Deputados.Despesa;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.Deputados.Despesa.dto.DespesaRequestDTO;
import com.example.Deputados.Despesa.dto.DespesaResponseDTO;

@Service
public class DespesaService {
    
    private DespesaRepository despesaRepository;
    private DespesaMapper despesaMapper;

    public DespesaService (DespesaRepository despesaRepository, DespesaMapper despesaMapper) {
        this.despesaRepository = despesaRepository;
        this.despesaMapper = despesaMapper; 
    }

    public List<DespesaResponseDTO> findAllDespesas() {
        return despesaRepository.findAll()
                .stream()
                .map(despesaMapper::toResponse)
                .toList();
    }

    public DespesaResponseDTO findDespesaById(Long id) {
        return despesaRepository.findById(id)
                .map(despesaMapper::toResponse)
                .orElseThrow(()-> new RuntimeException("Despesa não encontrada"));
    }

    public DespesaResponseDTO createDespesa(DespesaRequestDTO dto) {
        DespesaModel despesa = despesaMapper.toModel(dto);
        despesa = despesaRepository.save(despesa);
        return despesaMapper.toResponse(despesa);
    }

    public void deleteDespesa(Long id) {
        despesaRepository.deleteById(id);
    }
}
