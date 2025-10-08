package com.example.Deputados.Deputado;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeputadoService {

    @Autowired
    private DeputadoRepository deputadoRepository;

    public Optional<DeputadoModel> findById(Long id) {
        return deputadoRepository.findById(id);
    }

    public List<DeputadoModel> findAll() {
        return deputadoRepository.findAll();
    }

    public DeputadoModel save(DeputadoModel deputado) {
        return deputadoRepository.save(deputado);
    }

    public void deleteById(Long id) {
        deputadoRepository.deleteById(id);
    }
}
