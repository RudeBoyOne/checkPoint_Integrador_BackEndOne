package com.checkPoint.ProjetoIntegrador.api.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EnderecoPacienteDTOOutput {

    private String rua;
    private Integer numero;
    private String cep;
    private String cidade;
    private String estado;
}
