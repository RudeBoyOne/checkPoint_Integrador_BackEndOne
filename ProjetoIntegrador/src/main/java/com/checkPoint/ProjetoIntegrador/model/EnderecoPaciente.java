package com.checkPoint.ProjetoIntegrador.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EnderecoPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereco;

    @Column(nullable = false, length = 100)
    private String rua;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false, length = 60)
    private String cidade;

    @Column(nullable = false, length = 50)
    private String estado;

    @OneToOne(mappedBy = "enderecoPaciente")
    private Paciente paciente;

}
