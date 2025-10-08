package com.example.Deputados.Voto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    public List<VotoModel> findAll() {
        return votoRepository.findAll();
    }

    public Optional<VotoModel> findById(Long id) {
        return votoRepository.findById(id);
    }

    public VotoModel save(VotoModel voto) {
        return votoRepository.save(voto);
    }

    public void deleteById(Long id) {
        votoRepository.deleteById(id);
    }
}
