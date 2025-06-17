package com.seuprojeto.revendas.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seuprojeto.revendas.dto.RevendaDTO;
import com.seuprojeto.revendas.entity.Revenda;
import com.seuprojeto.revendas.exception.BusinessException;
import com.seuprojeto.revendas.repository.RevendaRepository;
import com.seuprojeto.revendas.service.RevendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
            throw new BusinessException("Não é possível cadastrar: este CNPJ já existe.", "Conflito ao registrar CNPJ", HttpStatus.CONFLICT.toString());
        });

        var entidade = objectMapper.convertValue(revendaDTO, Revenda.class);
        var salva = repository.save(entidade);
        return objectMapper.convertValue(salva, RevendaDTO.class);

    }

    @Override
    public RevendaDTO buscarRevendaPorId(Integer id) {
        Revenda revenda = repository.findById(id).orElseThrow(() -> new BusinessException("Nenhuma revenda encontrada com este ID.", "Recurso não encontrado", HttpStatus.NOT_FOUND.toString()));
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
    public void deletarUmaRevenda(Integer id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new BusinessException("Não possivel realizar deleção nenhuma revenda encontrada com este ID.", "Recurso não encontrado", HttpStatus.NOT_FOUND.toString())));

    }
}
