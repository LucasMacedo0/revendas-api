package com.seuprojeto.revendas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;


@Entity
@Table(name = "revendas")
@Getter
@Setter
@NoArgsConstructor
public class Revenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "O CNPJ é obrigatório")
    @Pattern(regexp = "\\d{14}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "CNPJ inválido")
    @CNPJ
    private String CNPJ;

    @Column(nullable = false)
    @NotBlank(message = "O nome social é obrigatório")
    private String NomeSocial;

}
