package com.example.Deputados.Proposicao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposicaoService {
    
    @Autowired
    private ProposicaoRepository proposicaoRepository;

    public List <ProposicaoModel> findAll(){
        return proposicaoRepository.findAll();
    }
    public Optional <ProposicaoModel> findById(Integer id) {
        return proposicaoRepository.findById(id);
    }
    public  ProposicaoModel save(ProposicaoModel proposicao) {
        return proposicaoRepository.save(proposicao);
    }
    public void deleteById(Integer id) {
        proposicaoRepository.deleteById(id);
    }
}
