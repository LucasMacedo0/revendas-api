package com.seuprojeto.revendas.repository;

import com.seuprojeto.revendas.entity.Oportunidade;
import com.seuprojeto.revendas.entity.StatusOportunidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {

    List<Oportunidade> findByRevendaId(Long revendaId);

    List<Oportunidade> findByUsuarioResponsavelIdAndStatus(Long usuarioId, StatusOportunidade status);
}