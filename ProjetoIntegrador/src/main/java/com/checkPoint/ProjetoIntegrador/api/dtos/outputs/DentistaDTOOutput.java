package com.checkPoint.ProjetoIntegrador.api.dtos.outputs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
public class DentistaDTOOutput {
    private Integer idDentista;
    private String nome;
    private String sobrenome;
}
