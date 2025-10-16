package com.example.Deputados.Voto;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.Deputados.Voto.dto.VotoRequestDTO;
import com.example.Deputados.Voto.dto.VotoResponseDTO;

@Service
public class VotoService {

    private VotoRepository votoRepository;
    private VotoMapper votoMapper;

    public  VotoService(VotoRepository votoRepository, VotoMapper votoMapper) {
        this.votoRepository = votoRepository;
        this.votoMapper = votoMapper;
    }

    public List<VotoResponseDTO> findAllVoto() {
        return votoRepository.findAll()
                .stream()
                .map(votoMapper::toResponse)
                .toList();
    }

    public VotoResponseDTO findVotoById(Long id) {
        return votoRepository.findById(id)
                .map(votoMapper::toResponse)
                .orElseThrow(()-> new RuntimeException("Voto não encontrado"));
    }

    public VotoResponseDTO createVoto(VotoRequestDTO dto) {
        VotoModel voto = votoMapper.toModel(dto);
        voto = votoRepository.save(voto);
        return votoMapper.toResponse(voto);
    }

    public void deleteVoto(Long id) {
        votoRepository.deleteById(id);
    }
}
