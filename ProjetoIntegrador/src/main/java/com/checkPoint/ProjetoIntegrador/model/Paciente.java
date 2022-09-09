package com.checkPoint.ProjetoIntegrador.model;

import lombok.*;

import java.util.List;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

    @NonNull
    @Column(nullable = false, length = 60)
    private String nome;

    @NonNull
    @Column(nullable = false, length = 60)
    private String sobrenome;

    @NonNull
    @Column(nullable = false, length = 10)
    private String rg;

    @NonNull
    private LocalDate dataAlta;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco")
    private EnderecoPaciente enderecoPaciente;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Consulta> consultas;

}
