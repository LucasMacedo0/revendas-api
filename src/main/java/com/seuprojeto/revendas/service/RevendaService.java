package com.seuprojeto.revendas.service;

import com.seuprojeto.revendas.dto.RevendaDTO;
import com.seuprojeto.revendas.entity.Revenda;

import java.util.List;

public interface RevendaService {

    RevendaDTO cadastrarRevenda(final RevendaDTO revendaDTO);

    RevendaDTO buscarRevendaPorId(final Integer id);

    List<RevendaDTO> listarTodasRevendas();

    void deletarUmaRevenda(final Integer id);

}
