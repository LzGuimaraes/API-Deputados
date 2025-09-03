package com.example.Deputados.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Deputados.model.Proposicao;

@Repository
public interface ProposicaoRepository extends JpaRepository<Proposicao, Integer>{
    
}
