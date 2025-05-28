package com.seuprojeto.revendas.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seuprojeto.revendas.dto.RevendaDTO;
import com.seuprojeto.revendas.entity.Revenda;
import com.seuprojeto.revendas.repository.RevendaRepository;
import com.seuprojeto.revendas.service.RevendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RevendaServiceImpl implements RevendaService {

    private final RevendaRepository repository;

    private final ObjectMapper objectMapper;

    @Override
    public RevendaDTO cadastrarRevenda(RevendaDTO revendaDTO) {
        repository.findByCnpj(revendaDTO.getCnpj()).ifPresent(e -> {
            //TODO realizar tratamento de exception no lugar do RuntimeException aqui
            throw new RuntimeException("erro esse CNPJ já é cadastrado");
        });
        Revenda novaRevenda = repository.save(objectMapper.convertValue(revendaDTO, Revenda.class));
        return objectMapper.convertValue(novaRevenda, RevendaDTO.class);

    }

    @Override
    public RevendaDTO buscarRevendaPorId(Long id) {
        //TODO realizar tratamento de exception no lugar do RuntimeException aqui
        Revenda revenda = repository.findById(id).orElseThrow(() -> new RuntimeException("Revenda não encontrada"));
        return objectMapper.convertValue(revenda, RevendaDTO.class);
    }

    @Override
    public List<RevendaDTO> listarTodasRevendas() {
        List<Revenda> revendas = repository.findAll();

        return revendas.stream()
                .map(revenda -> objectMapper.convertValue(revenda, RevendaDTO.class))
                .toList();
    }

    @Override
    public void deletarUmaRevenda(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revenda não encontrada")));

    }
}
