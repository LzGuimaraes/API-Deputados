package com.example.Deputados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Deputados.model.Proposicao;
import com.example.Deputados.repository.ProposicaoRepository;

@Service
public class ProposicaoService {
    
    @Autowired
    private ProposicaoRepository proposicaoRepository;

    public List <Proposicao> findAll(){
        return proposicaoRepository.findAll();
    }
    public Optional <Proposicao> findById(Integer id) {
        return proposicaoRepository.findById(id);
    }
    public  Proposicao save(Proposicao proposicao) {
        return proposicaoRepository.save(proposicao);
    }
    public void deleteById(Integer id) {
        proposicaoRepository.deleteById(id);
    }
}
