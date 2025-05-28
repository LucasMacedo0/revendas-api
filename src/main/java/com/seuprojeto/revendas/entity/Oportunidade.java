package com.seuprojeto.revendas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOportunidade status = StatusOportunidade.NOVO;

    private String motivoConclusao;

    @NotBlank
    private String nomeCliente;

    @NotBlank
    private String emailCliente;

    @NotBlank
    private String telefoneCliente;

    @NotBlank
    private String marcaVeiculo;

    @NotBlank
    private String modeloVeiculo;

    @NotBlank
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
