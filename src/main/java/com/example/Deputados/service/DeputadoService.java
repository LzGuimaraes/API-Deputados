package com.example.Deputados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Deputados.model.Deputado;
import com.example.Deputados.repository.DeputadoRepository;

@Service
public class DeputadoService {

    @Autowired
    private DeputadoRepository deputadoRepository;

    public Optional<Deputado> findById(Long id) {
        return deputadoRepository.findById(id);
    }

    public List<Deputado> findAll() {
        return deputadoRepository.findAll();
    }

    public Deputado save(Deputado deputado) {
        return deputadoRepository.save(deputado);
    }

    public void deleteById(Long id) {
        deputadoRepository.deleteById(id);
    }
}
