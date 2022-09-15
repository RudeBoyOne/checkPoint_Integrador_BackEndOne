package com.checkPoint.ProjetoIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


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

    private LocalDate dataAlta;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco")
    private EnderecoPaciente enderecoPaciente;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Consulta> consultas;

}
