package com.example.Deputados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Deputados.model.Deputado;
import com.example.Deputados.model.Proposicao;
import com.example.Deputados.service.DeputadoService;
import com.example.Deputados.service.ProposicaoService; 

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/proposicao")
public class ProposicaoController {

    @Autowired
    private ProposicaoService proposicaoService;

    @Autowired 
    private DeputadoService deputadoService;

    @PostMapping
    public ResponseEntity <Proposicao> create(@RequestBody Proposicao proposicao) {
        Optional<Deputado> deputadoOpt = deputadoService.findById(proposicao.getAutor().getId());
        
        if (!deputadoOpt.isPresent()) {
            return ResponseEntity.badRequest().build(); 
        }

        proposicao.setAutor(deputadoOpt.get());
        
        Proposicao novaProposicao = proposicaoService.save(proposicao);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(novaProposicao);
    }

    @GetMapping
    public List<Proposicao> getAll() {
        return proposicaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proposicao> getById(@PathVariable Integer id) {
        Optional<Proposicao> proposicao = proposicaoService.findById(id);
        return proposicao.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (proposicaoService.findById(id).isPresent()) {
            proposicaoService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}