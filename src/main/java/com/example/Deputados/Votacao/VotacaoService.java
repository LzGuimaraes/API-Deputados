package com.example.Deputados.Votacao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotacaoService {

    private final VotacaoRepository votacaoRepository;

    public List<VotacaoModel> findAll() {
        return votacaoRepository.findAll();
    }

    public Optional<VotacaoModel> findById(Integer id) {
        return votacaoRepository.findById(id);
    }

    public VotacaoModel save(VotacaoModel votacao) {
        return votacaoRepository.save(votacao);
    }

    public void deleteById(Integer id) {
        votacaoRepository.deleteById(id);
    }
}
