package com.example.Deputados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Deputados.model.Votacao;
import com.example.Deputados.service.VotacaoService;

@RestController
@RequestMapping("/api/votacao")
public class VotacaoController {

    @Autowired
    private VotacaoService votacaoService;

    @PostMapping
    public ResponseEntity<Votacao> create(@RequestBody Votacao votacao) {
        Votacao novaVotacao = votacaoService.save(votacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVotacao);
    }

    @GetMapping
    public List<Votacao> getAll() {
        return votacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Votacao> getById(@PathVariable Integer id) {
        Optional<Votacao> votacao = votacaoService.findById(id);
        return votacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (votacaoService.findById(id).isPresent()) {
            votacaoService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
