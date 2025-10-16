package com.example.Deputados.Deputado;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Deputados.Deputado.dto.DeputadoRequestDTO;
import com.example.Deputados.Deputado.dto.DeputadoResponseDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/deputados")
public class DeputadoController {

    private DeputadoService deputadoService;

    public DeputadoController(DeputadoService deputadoService){
        this.deputadoService = deputadoService;
    }

    @GetMapping("/all")
    public List<DeputadoResponseDTO> findAllDeputados() {
        return deputadoService.findAllDeputados();
    }

    @GetMapping("all/{id}")
    public DeputadoResponseDTO findDeputadoById(@PathVariable Long id) {
        return deputadoService.findDeputadoById(id);
    }
    
    @PostMapping("/create")
    public ResponseEntity<DeputadoResponseDTO> create(@RequestBody DeputadoRequestDTO dto) {
        DeputadoResponseDTO response = deputadoService.createDeputado(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDeputado(Long id) {
        deputadoService.deleteDeputado(id);
    }
}
