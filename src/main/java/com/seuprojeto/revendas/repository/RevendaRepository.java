package com.seuprojeto.revendas.repository;

import com.seuprojeto.revendas.entity.Revenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RevendaRepository extends JpaRepository<Revenda, Integer> {

    Optional<Revenda> findByCnpj(String cnpj);

}