package com.checkPoint.ProjetoIntegrador.api.dtos.inputs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
public class PacienteDTOInput {
    private String nome;
    private String sobrenome;
    private String matriculaCadastro;
}
