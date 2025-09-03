package com.example.Deputados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Deputados.model.Voto;
import com.example.Deputados.repository.VotoRepository;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    public List<Voto> findAll() {
        return votoRepository.findAll();
    }

    public Optional<Voto> findById(Long id) {
        return votoRepository.findById(id);
    }

    public Voto save(Voto voto) {
        return votoRepository.save(voto);
    }

    public void deleteById(Long id) {
        votoRepository.deleteById(id);
    }
}
