package com.seuprojeto.revendas.Controller;

import com.seuprojeto.revendas.dto.RevendaDTO;
import com.seuprojeto.revendas.service.RevendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RevendaController {

    @Autowired
    private RevendaService revendaService;

    @PostMapping
    public ResponseEntity<RevendaDTO> cadastrarRevenda(@RequestBody RevendaDTO revendaDTO) {
        revendaService.cadastrarRevenda(revendaDTO);
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevendaDTO> buscarRevendaPorId(@PathVariable Long id) {
        revendaService.buscarRevendaPorId(id);
        return null;
    }

    @GetMapping("/revendas")
    public ResponseEntity<List<RevendaDTO>> listarTodasRevendas() {
        List<RevendaDTO> revendasDTO = revendaService.listarTodasRevendas();
        return ResponseEntity.ok(revendasDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUmaRevenda(@PathVariable Long id) {
        revendaService.deletarUmaRevenda(id);
        return ResponseEntity.noContent().build();
    }
}
