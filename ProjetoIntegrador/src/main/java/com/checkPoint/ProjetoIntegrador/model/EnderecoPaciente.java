package com.checkPoint.ProjetoIntegrador.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EnderecoPaciente {
    private Integer idEndereco;
    private String rua;
    private Integer numero;
    private String cep;
    private String cidade;
    private String estado;

}
