package com.example.Deputados.Despesa;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Deputados.Despesa.dto.DespesaRequestDTO;
import com.example.Deputados.Despesa.dto.DespesaResponseDTO;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    private DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @GetMapping("/all")
    public List<DespesaResponseDTO> findAllDespesas() {
        return despesaService.findAllDespesas();
    }

    @GetMapping("/all/{id}")
    public DespesaResponseDTO findDespesaById(@PathVariable Long id) {
        return despesaService.findDespesaById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<DespesaResponseDTO> create(@RequestBody DespesaRequestDTO dto) {
        DespesaResponseDTO response = despesaService.createDespesa(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDespesa(Long id) {
        despesaService.deleteDespesa(id);
    }
}

