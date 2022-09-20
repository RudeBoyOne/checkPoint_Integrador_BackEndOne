package com.checkPoint.ProjetoIntegrador.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsulta;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    @NonNull
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idDentista")
    @NonNull
    private Dentista dentista;

    @NonNull
    private LocalDateTime dataHoraConsulta;
}
