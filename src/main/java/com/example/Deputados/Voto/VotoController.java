package com.example.Deputados.Voto;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Deputados.Voto.dto.VotoRequestDTO;
import com.example.Deputados.Voto.dto.VotoResponseDTO;

@RestController
@RequestMapping("/votos")
public class VotoController {

    private VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @GetMapping("/all")    
    public List<VotoResponseDTO> findAllVoto() {
        return votoService.findAllVoto();
    }
    
    @GetMapping("/{id}")
    public VotoResponseDTO findVotoById(@PathVariable Long id) {
        return votoService.findVotoById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<VotoResponseDTO> createVoto(@RequestBody VotoRequestDTO dto) {
        VotoResponseDTO response = votoService.createVoto(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public void deleteVoto(Long id) {
        votoService.deleteVoto(id);
    }
}
