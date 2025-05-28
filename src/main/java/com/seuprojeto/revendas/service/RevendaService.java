package com.seuprojeto.revendas.service;

import com.seuprojeto.revendas.dto.RevendaDTO;

public interface RevendaService {

    RevendaDTO cadastrarRevenda(final RevendaDTO revendaDTO);

    RevendaDTO buscarRevendaPorId(final RevendaDTO revendaDTO);

    RevendaDTO listarTodasRevendas();

    RevendaDTO deletarUmaRevenda(final Long id);

}
