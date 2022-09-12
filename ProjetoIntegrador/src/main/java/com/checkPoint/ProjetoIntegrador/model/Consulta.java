package com.checkPoint.ProjetoIntegrador.model;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPaciente")
    @NonNull
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDentista")
    @NonNull
    private Dentista dentista;

    @NonNull
    private LocalDateTime dataHoraConsulta;
}
