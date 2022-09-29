package com.checkPoint.ProjetoIntegrador.api.dtos.inputs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class EnderecoPacienteDTOInput {

    @NotBlank
    private String rua;

    @NotNull
    private Integer numero;

    @NotBlank
    private String cep;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;
}
