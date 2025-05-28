package com.seuprojeto.revendas.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seuprojeto.revendas.dto.RevendaDTO;
import com.seuprojeto.revendas.entity.Revenda;
import com.seuprojeto.revendas.repository.RevendaRepository;
import com.seuprojeto.revendas.service.RevendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RevendaServiceImpl implements RevendaService {

    @Autowired
    private RevendaRepository repository;

    private ObjectMapper objectMapper;

    @Override
    public RevendaDTO cadastrarRevenda(RevendaDTO revendaDTO) {
        repository.findByCnpj(revendaDTO.getCnpj()).ifPresent(e -> {
            //TODO realizar tratamento aqui
            throw new RuntimeException("erro");
        });
        Revenda novaRevenda = repository.save(objectMapper.convertValue(revendaDTO, Revenda.class););

        return objectMapper.convertValue(novaRevenda, RevendaDTO.class);

    }

    @Override
    public RevendaDTO buscarRevendaPorId(RevendaDTO revendaDTO) {
        return null;
    }

    @Override
    public RevendaDTO listarTodasRevendas() {
        return null;
    }

    @Override
    public RevendaDTO deletarUmaRevenda(Long id) {
        return null;
    }
}
