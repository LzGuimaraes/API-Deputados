package com.example.Deputados.Votacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votacao")
public class VotacaoController {

    @Autowired
    private VotacaoService votacaoService;

    @PostMapping
    public ResponseEntity<VotacaoModel> create(@RequestBody VotacaoModel votacao) {
        VotacaoModel novaVotacao = votacaoService.save(votacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVotacao);
    }

    @GetMapping
    public List<VotacaoModel> getAll() {
        return votacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VotacaoModel> getById(@PathVariable Integer id) {
        Optional<VotacaoModel> votacao = votacaoService.findById(id);
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
