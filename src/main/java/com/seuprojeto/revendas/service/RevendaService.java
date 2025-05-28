package com.seuprojeto.revendas.service;

import com.seuprojeto.revendas.dto.RevendaDTO;
import com.seuprojeto.revendas.entity.Revenda;

import java.util.List;

public interface RevendaService {

    RevendaDTO cadastrarRevenda(final RevendaDTO revendaDTO);

    RevendaDTO buscarRevendaPorId(final Long id);

    List<RevendaDTO> listarTodasRevendas();

    void deletarUmaRevenda(final Long id);

}
