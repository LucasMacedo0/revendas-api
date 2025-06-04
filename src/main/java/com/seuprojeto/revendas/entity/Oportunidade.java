package com.seuprojeto.revendas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "oportunidades")
@Getter
@Setter
@NoArgsConstructor
public class Oportunidade {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOportunidade status = StatusOportunidade.NOVO;

    private String motivoConclusao;

    private String nomeCliente;

    private String emailCliente;

    private String telefoneCliente;

    private String marcaVeiculo;

    private String modeloVeiculo;

    private String versaoVeiculo;

    private Integer anoModelo;

    @ManyToOne
    @JoinColumn(name = "revenda_id")
    private Revenda revenda;

    @ManyToOne
    @JoinColumn(name = "usuario_responsavel_id")
    private Usuario usuarioResponsavel;

    private LocalDate dataAtribuicao;

    private LocalDate dataConclusao;

}
