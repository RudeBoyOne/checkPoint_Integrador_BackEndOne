package com.checkPoint.ProjetoIntegrador.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Paciente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

    @NotBlank
    @NotNull
    @Size(max = 60)
    @NonNull
    @Column(nullable = false, length = 60)
    private String nome;

    @NotBlank
    @NotNull
    @Size(max = 60)
    @NonNull
    @Column(nullable = false, length = 60)
    private String sobrenome;

    @NotBlank
    @NotNull
    @Size(max = 10)
    @NonNull
    @Column(nullable = false, length = 10)
    private String rg;

    private LocalDate dataAlta;

    @Valid
    @NotNull
    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco")
    private EnderecoPaciente enderecoPaciente;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Consulta> consultas;

}
