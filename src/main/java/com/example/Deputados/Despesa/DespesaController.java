package com.example.Deputados.Despesa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Deputados.Deputado.DeputadoModel;
import com.example.Deputados.Deputado.DeputadoService;

@RestController
@RequestMapping("/api/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @Autowired
    private DeputadoService deputadoService;

    @PostMapping
    public ResponseEntity<DespesaModel> create(@RequestBody DespesaModel despesa) {
        Optional<DeputadoModel> deputadoOpt = deputadoService.findById(despesa.getDeputado().getId());
        if (!deputadoOpt.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        despesa.setDeputado(deputadoOpt.get());
        DespesaModel novaDespesa = despesaService.save(despesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDespesa);
    }

    @GetMapping
    public List<DespesaModel> getAll() {
        return despesaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaModel> getById(@PathVariable Long id) {
        Optional<DespesaModel> despesa = despesaService.findById(id);
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
