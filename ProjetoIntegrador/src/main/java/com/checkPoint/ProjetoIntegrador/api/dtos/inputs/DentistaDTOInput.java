package com.checkPoint.ProjetoIntegrador.api.dtos.inputs;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class DentistaDTOInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String matriculaCadastro;
}
