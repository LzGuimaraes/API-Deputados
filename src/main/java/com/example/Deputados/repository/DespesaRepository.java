package com.example.Deputados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Deputados.model.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long>{
    
}

