package com.checkPoint.ProjetoIntegrador.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class EnderecoPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereco;


    @NotBlank
    @NonNull
    @Column(nullable = false, length = 100)
    private String rua;

    @NotNull
    @NonNull
    @Column(nullable = false)
    private Integer numero;

    @NotBlank
    @Size(max = 8)
    @NonNull
    @Column(nullable = false, length = 8)
    private String cep;

    @NotBlank
    @Size(max = 60)
    @NonNull
    @Column(nullable = false, length = 60)
    private String cidade;


    @NotBlank
    @Size(max = 50)
    @NonNull
    @Column(nullable = false, length = 50)
    private String estado;

}
