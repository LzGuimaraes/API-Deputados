package com.example.Deputados.Despesa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public List<DespesaModel> findAll() {
        return despesaRepository.findAll();
    }

    public Optional<DespesaModel> findById(Long id) {
        return despesaRepository.findById(id);
    }

    public DespesaModel save(DespesaModel despesa) {
        return despesaRepository.save(despesa);
    }

    public void deleteById(Long id) {
        despesaRepository.deleteById(id);
    }
}
