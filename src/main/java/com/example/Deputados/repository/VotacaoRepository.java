package com.example.Deputados.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Deputados.model.Votacao;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Integer>{
    
}
