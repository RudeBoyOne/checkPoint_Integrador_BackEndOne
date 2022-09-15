package com.checkPoint.ProjetoIntegrador.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class EnderecoPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereco;

    @NonNull
    @Column(nullable = false, length = 100)
    private String rua;

    @NonNull
    @Column(nullable = false)
    private Integer numero;

    @NonNull
    @Column(nullable = false, length = 8)
    private String cep;

    @NonNull
    @Column(nullable = false, length = 60)
    private String cidade;

    @NonNull
    @Column(nullable = false, length = 50)
    private String estado;

}
