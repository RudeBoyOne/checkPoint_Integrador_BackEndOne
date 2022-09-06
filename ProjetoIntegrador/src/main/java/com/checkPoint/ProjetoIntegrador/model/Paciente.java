package com.checkPoint.ProjetoIntegrador.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private Integer idPaciente;
    private String nome;
    private String sobrenome;
    private EnderecoPaciente enderecoPaciente;
    private String rg;
    private LocalDate dataAlta;
}
