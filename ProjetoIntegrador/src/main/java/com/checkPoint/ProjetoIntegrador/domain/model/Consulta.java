package com.checkPoint.ProjetoIntegrador.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Consulta {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsulta;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDentista")
    private Dentista dentista;

    @NonNull
    private LocalDateTime dataHoraConsulta;
}
