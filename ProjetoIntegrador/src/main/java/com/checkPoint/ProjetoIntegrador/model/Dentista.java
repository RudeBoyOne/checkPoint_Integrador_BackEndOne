package com.checkPoint.ProjetoIntegrador.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDentista;

    @NonNull
    @Column(nullable = false, length = 60)
    private String nome;

    @NonNull
    @Column(nullable = false, length = 60)
    private String sobrenome;

    @NonNull
    @Column(nullable = false, length = 10)
    private String matriculaCadastro;

    @OneToMany(mappedBy = "dentista", fetch = FetchType.LAZY)
    private List<Consulta> consultas;
}
