package com.example.Deputados.Votacao;

import org.springframework.stereotype.Service;

import com.example.Deputados.Votacao.dto.VotacaoRequestDTO;
import com.example.Deputados.Votacao.dto.VotacaoResponseDTO;

import java.util.List;

@Service
public class VotacaoService {

    private VotacaoRepository votacaoRepository;
    private VotacaoMapper votacaoMapper;

    public VotacaoService (VotacaoRepository votacaoRepository,VotacaoMapper votacaoMapper) {
        this.votacaoMapper = votacaoMapper;
        this.votacaoRepository = votacaoRepository;
    }

   public List<VotacaoResponseDTO> findAllVotacao() {
        return votacaoRepository.findAll()
                .stream()
                .map(votacaoMapper::toResponse)
                .toList();
    }

     public VotacaoResponseDTO findVotacaoById(Long id) {
        return votacaoRepository.findById(id)
                .map(votacaoMapper::toResponse)
                .orElseThrow(()-> new RuntimeException("Votacao não encontrada"));
    }

    public VotacaoResponseDTO createVotacao(VotacaoRequestDTO dto) {
        VotacaoModel votacao = votacaoMapper.toModel(dto);
        votacao = votacaoRepository.save(votacao);
        return votacaoMapper.toResponse(votacao);
    }

    public void deleteVotacao(Long id) {
        votacaoRepository.deleteById(id);
    }
}
