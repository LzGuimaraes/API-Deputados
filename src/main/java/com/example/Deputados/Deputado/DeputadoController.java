package com.example.Deputados.Deputado;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public DeputadoModel create (@RequestBody DeputadoModel deputado) {
        return deputadoService.save(deputado);
    }

    @GetMapping()
    public List <DeputadoModel> getAll() {
        return deputadoService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DeputadoModel> getById(@PathVariable Long id) {
        Optional<DeputadoModel> deputado = deputadoService.findById(id);
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
