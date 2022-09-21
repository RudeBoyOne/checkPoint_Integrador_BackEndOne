package com.checkPoint.ProjetoIntegrador.api.dtos.inputs;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PacienteDTOInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotNull
    private String rg;

    @Valid
    @NotNull
    private EnderecoPacienteDTOInput enderecoPaciente;
}
