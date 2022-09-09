package com.checkPoint.ProjetoIntegrador.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsulta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDentista")
    private Dentista dentista;

    private LocalDateTime dataHoraConsulta;
}
