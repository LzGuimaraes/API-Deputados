package com.example.Deputados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Deputados.model.Despesa;
import com.example.Deputados.repository.DespesaRepository;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public List<Despesa> findAll() {
        return despesaRepository.findAll();
    }

    public Optional<Despesa> findById(Long id) {
        return despesaRepository.findById(id);
    }

    public Despesa save(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    public void deleteById(Long id) {
        despesaRepository.deleteById(id);
    }
}
