package com.example.Deputados.Voto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Deputados.Deputado.DeputadoModel;
import com.example.Deputados.Deputado.DeputadoService;
import com.example.Deputados.Votacao.VotacaoModel;
import com.example.Deputados.Votacao.VotacaoService;

@RestController
@RequestMapping("/api/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @Autowired
    private DeputadoService deputadoService;

    @Autowired
    private VotacaoService votacaoService;

    @PostMapping
    public ResponseEntity<VotoModel> create(@RequestBody VotoModel voto) {
        Optional<DeputadoModel> deputadoOpt = deputadoService.findById(voto.getDeputado().getId());
        if (!deputadoOpt.isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<VotacaoModel> votacaoOpt = votacaoService.findById(voto.getVotacao().getId());
        if (!votacaoOpt.isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }

        voto.setDeputado(deputadoOpt.get());
        voto.setVotacao(votacaoOpt.get());

        VotoModel novoVoto = votoService.save(voto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVoto);
    }

    @GetMapping
    public List<VotoModel> getAll() {
        return votoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VotoModel> getById(@PathVariable Long id) {
        Optional<VotoModel> voto = votoService.findById(id);
        return voto.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (votoService.findById(id).isPresent()) {
            votoService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
