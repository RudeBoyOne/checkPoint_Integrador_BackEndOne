package com.checkPoint.ProjetoIntegrador.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistaDTO {
    private String nome;
    private String sobrenome;
    private String matriculaCadastro;
}
