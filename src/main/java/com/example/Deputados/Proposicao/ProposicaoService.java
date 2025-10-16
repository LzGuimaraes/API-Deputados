package com.example.Deputados.Proposicao;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.Deputados.Proposicao.dto.ProposicaoRequestDTO;
import com.example.Deputados.Proposicao.dto.ProposicaoResponseDTO;

@Service
public class ProposicaoService {
    
    private ProposicaoRepository proposicaoRepository;
    private ProposicaoMapper proposicaoMapper;
    
    public ProposicaoService (ProposicaoRepository proposicaoRepository, ProposicaoMapper proposicaoMapper) {
        this.proposicaoRepository = proposicaoRepository;
        this.proposicaoMapper = proposicaoMapper;

    } 

   public List<ProposicaoResponseDTO> findAllProposicao() {
        return proposicaoRepository.findAll()
                .stream()
                .map(proposicaoMapper::toResponse)
                .toList();
    }

    public ProposicaoResponseDTO findProposicaoById(Long id) {
        return proposicaoRepository.findById(id)
                .map(proposicaoMapper::toResponse)
                .orElseThrow(()-> new RuntimeException("Proposição não encontrada"));
    }

   public ProposicaoResponseDTO createProposicao(ProposicaoRequestDTO dto) {
        ProposicaoModel proposicao = proposicaoMapper.toModel(dto);
        proposicao = proposicaoRepository.save(proposicao);
        return proposicaoMapper.toResponse(proposicao);
    }

    public void deleteProposicao(Long id) {
        proposicaoRepository.deleteById(id);
    }
}
