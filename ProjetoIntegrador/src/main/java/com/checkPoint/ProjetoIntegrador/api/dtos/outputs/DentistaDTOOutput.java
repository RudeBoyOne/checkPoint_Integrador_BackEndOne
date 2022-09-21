package com.checkPoint.ProjetoIntegrador.api.dtos.outputs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
public class DentistaDTOOutput {
    private Integer idDentista;
    private String nome;
    private String sobrenome;
}
