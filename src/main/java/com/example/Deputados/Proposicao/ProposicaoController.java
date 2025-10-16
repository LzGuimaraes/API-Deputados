package com.example.Deputados.Proposicao;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Deputados.Proposicao.dto.ProposicaoRequestDTO;
import com.example.Deputados.Proposicao.dto.ProposicaoResponseDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/proposicao")
public class ProposicaoController {


    private ProposicaoService proposicaoService;
    public ProposicaoController(ProposicaoService proposicaoService) {
        this.proposicaoService = proposicaoService;
    }


    @GetMapping("/all")
    public List<ProposicaoResponseDTO> findAllProposicao() {
        return proposicaoService.findAllProposicao();
    }

    @GetMapping("/{id}")
    public ProposicaoResponseDTO findProposicaoById(@PathVariable Long id) {
        return proposicaoService.findProposicaoById(id);
    }
    

    @PostMapping("/create")
    public ResponseEntity<ProposicaoResponseDTO> create(@RequestBody ProposicaoRequestDTO dto) {
        ProposicaoResponseDTO response = proposicaoService.createDespesa(dto);
        return ResponseEntity.ok(response);
    }
  
   @DeleteMapping("delete/{id}")
    public void deleteProposicao(Long id) {
        proposicaoService.deleteProposicao(id);
    }
}