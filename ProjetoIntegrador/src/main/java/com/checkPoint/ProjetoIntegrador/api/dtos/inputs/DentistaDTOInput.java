package com.checkPoint.ProjetoIntegrador.api.dtos.inputs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DentistaDTOInput {
    private String nome;
    private String sobrenome;
    private String rg;
    private EnderecoPacienteDTOInput enderecoPacienteDTOInput;
}
