package com.checkPoint.ProjetoIntegrador.api.dtos.outputs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
public class PacienteDTOOutput {
    private Integer idPaciente;
    private String nome;
    private String sobrenome;
    private EnderecoPacienteDTOOutput enderecoPaciente;
}
