package com.example.Deputados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Deputados.model.Deputado;

public interface DeputadoRepository extends JpaRepository<Deputado, Long> {
}
