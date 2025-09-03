package com.example.Deputados.service;

import com.example.Deputados.model.Votacao;
import com.example.Deputados.repository.ProposicaoRepository;
import com.example.Deputados.repository.VotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotacaoService {

    private final VotacaoRepository votacaoRepository;
    private final ProposicaoRepository proposicaoRepository;

    public List<Votacao> findAll() {
        return votacaoRepository.findAll();
    }

    public Optional<Votacao> findById(Integer id) {
        return votacaoRepository.findById(id);
    }

    public Votacao save(Votacao votacao) {
        return votacaoRepository.save(votacao);
    }

    public void deleteById(Integer id) {
        votacaoRepository.deleteById(id);
    }
}
