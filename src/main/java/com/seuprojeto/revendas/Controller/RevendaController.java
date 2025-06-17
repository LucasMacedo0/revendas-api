package com.seuprojeto.revendas.Controller;

import com.seuprojeto.revendas.dto.RevendaDTO;
import com.seuprojeto.revendas.service.RevendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/revendas")
public class RevendaController {

    private final RevendaService revendaService;

    @PostMapping
    public ResponseEntity<RevendaDTO> cadastrarRevenda(@RequestBody @Valid RevendaDTO revendaDTO) {
        RevendaDTO response = revendaService.cadastrarRevenda(revendaDTO);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<RevendaDTO> buscarRevendaPorId(@PathVariable Integer id) {
        revendaService.buscarRevendaPorId(id);
        return null;
    }

    @GetMapping
    public ResponseEntity<List<RevendaDTO>> listarTodasRevendas() {
        List<RevendaDTO> revendasDTO = revendaService.listarTodasRevendas();
        return ResponseEntity.ok(revendasDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUmaRevenda(@PathVariable Integer id) {
        revendaService.deletarUmaRevenda(id);
        return ResponseEntity.noContent().build();
    }
}
