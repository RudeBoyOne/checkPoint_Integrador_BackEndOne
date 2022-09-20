package com.checkPoint.ProjetoIntegrador.api.dtos.inputs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoPacienteDTOInput {
    private String rua;
    private Integer numero;
    private String cep;
    private String cidade;
    private String estado;
}
