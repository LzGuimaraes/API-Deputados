package com.example.Deputados.Votacao;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Deputados.Votacao.dto.VotacaoRequestDTO;
import com.example.Deputados.Votacao.dto.VotacaoResponseDTO;


@RestController
@RequestMapping("votacao")
public class VotacaoController {

    private VotacaoService votacaoService;

    public VotacaoController (VotacaoService votacaoService) {
        this.votacaoService = votacaoService;
    }

    @GetMapping("/all")    
    public List<VotacaoResponseDTO> findAllVotacao() {
        return votacaoService.findAllVotacao();
    }
    
    @GetMapping("/{id}")
    public VotacaoResponseDTO findVotacaoById(@PathVariable Long id) {
        return votacaoService.findVotacaoById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<VotacaoResponseDTO> create(@RequestBody VotacaoRequestDTO dto) {
        VotacaoResponseDTO response = votacaoService.createVotacao(dto);
        return ResponseEntity.ok(response);
    }   

   @DeleteMapping("delete/{id}")
    public void deleteVotacao(Long id) {
        votacaoService.deleteVotacao(id);
    }
}
