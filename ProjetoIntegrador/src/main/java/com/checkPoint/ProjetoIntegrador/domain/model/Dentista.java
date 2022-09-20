package com.checkPoint.ProjetoIntegrador.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Dentista {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDentista;

    @NotBlank
    @NotNull
    @Size(max=60)
    @NonNull
    @Column(nullable = false, length = 60)
    private String nome;

    @NotBlank
    @NotNull
    @Size(max=60)
    @NonNull
    @Column(nullable = false, length = 60)
    private String sobrenome;

    @NotBlank
    @NotNull
    @Size(max=10)
    @NonNull
    @Column(nullable = false, length = 10)
    private String matriculaCadastro;

    @OneToMany(mappedBy = "dentista", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Consulta> consultas;
}
