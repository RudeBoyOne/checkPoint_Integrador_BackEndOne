package com.checkPoint.ProjetoIntegrador.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
    private Integer idConsulta;
    private Paciente paciente;
    private Dentista dentista;
    private LocalDateTime dataHoraConsulta;
}
