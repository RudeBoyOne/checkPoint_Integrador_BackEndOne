package com.checkPoint.ProjetoIntegrador.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Dentista {
    private Integer idDentista;
    private String nome;
    private String sobrenome;
    private String matriculaCadastro;

}
