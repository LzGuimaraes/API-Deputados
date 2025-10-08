package com.example.Deputados.Votacao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Integer>{
    
}
