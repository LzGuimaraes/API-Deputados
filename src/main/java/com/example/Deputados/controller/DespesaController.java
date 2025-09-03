package com.example.Deputados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Deputados.model.Deputado;
import com.example.Deputados.model.Despesa;
import com.example.Deputados.service.DeputadoService;
import com.example.Deputados.service.DespesaService;

@RestController
@RequestMapping("/api/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @Autowired
    private DeputadoService deputadoService;

    @PostMapping
    public ResponseEntity<Despesa> create(@RequestBody Despesa despesa) {
        Optional<Deputado> deputadoOpt = deputadoService.findById(despesa.getDeputado().getId());
        if (!deputadoOpt.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        despesa.setDeputado(deputadoOpt.get());
        Despesa novaDespesa = despesaService.save(despesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDespesa);
    }

    @GetMapping
    public List<Despesa> getAll() {
        return despesaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> getById(@PathVariable Long id) {
        Optional<Despesa> despesa = despesaService.findById(id);
        return despesa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (despesaService.findById(id).isPresent()) {
            despesaService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
