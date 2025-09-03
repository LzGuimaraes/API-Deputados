package com.example.Deputados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Deputados.model.Deputado;
import com.example.Deputados.service.DeputadoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/deputados")
public class DeputadoController {
    @Autowired
    private DeputadoService deputadoService;

    @PostMapping
    public Deputado create (@RequestBody Deputado deputado) {
        return deputadoService.save(deputado);
    }

    @GetMapping()
    public List <Deputado> getAll() {
        return deputadoService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Deputado> getById(@PathVariable Long id) {
        Optional<Deputado> deputado = deputadoService.findById(id);
        return deputado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (deputadoService.findById(id).isPresent()) {
            deputadoService.deleteById(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
