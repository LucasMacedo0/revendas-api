package com.seuprojeto.revendas.dto;

import com.seuprojeto.revendas.entity.StatusOportunidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Data
public class OportunidadeDTO {


    private Long id;

    @NotBlank(message = "O nome do cliente é obrigatório")
    private String nomeCliente;

    @NotBlank(message = "O e-mail do cliente é obrigatório")
    private String emailCliente;

    @NotBlank(message = "O telefone do cliente é obrigatório")
    private String telefoneCliente;

    @NotBlank(message = "A marca do veículo é obrigatória")
    private String marcaVeiculo;

    @NotBlank(message = "O modelo do veículo é obrigatório")
    private String modeloVeiculo;

    @NotBlank(message = "A versão do veículo é obrigatória")
    private String versaoVeiculo;

    @NotNull(message = "O ano modelo do veículo é obrigatório")
    private Integer anoModelo;

    private StatusOportunidade status;

    private String motivoConclusao;

    private Long usuarioResponsavelId;

    private Long revendaId;

    private LocalDateTime dataAtribuicao;

    private LocalDateTime dataConclusao;

}
