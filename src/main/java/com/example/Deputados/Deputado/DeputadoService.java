package com.example.Deputados.Deputado;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.Deputados.Deputado.dto.DeputadoRequestDTO;
import com.example.Deputados.Deputado.dto.DeputadoResponseDTO;
import com.example.Deputados.Despesa.DespesaRepository;
import com.example.Deputados.Proposicao.ProposicaoRepository;

@Service
public class DeputadoService {

    private DeputadoRepository deputadoRepository;
    private DeputadoMapper deputadoMapper;


    public DeputadoService(DeputadoRepository deputadoRepository,DeputadoMapper deputadoMapper, DespesaRepository despesaRepository,ProposicaoRepository proposicaoRepository) {
        this.deputadoRepository = deputadoRepository;
        this.deputadoMapper = deputadoMapper;
    }

    public List<DeputadoResponseDTO> findAllDeputados() {
        return deputadoRepository.findAll()
                .stream()
                .map(deputadoMapper::toResponse)
                .toList();
    }

    public DeputadoResponseDTO findDeputadoById(Long id) {
        return deputadoRepository.findById(id)
                    .map(deputadoMapper::toResponse)
                    .orElseThrow(() -> new RuntimeException("Deputado não encontrado"));
    }

    public DeputadoResponseDTO createDeputado(DeputadoRequestDTO dto) {
        DeputadoModel deputado = deputadoMapper.toModel(dto);

        deputado = deputadoRepository.save(deputado);
        return deputadoMapper.toResponse(deputado);
            
    }

    public void deleteDeputado(Long id) {
        deputadoRepository.deleteById(id);
    }
}
