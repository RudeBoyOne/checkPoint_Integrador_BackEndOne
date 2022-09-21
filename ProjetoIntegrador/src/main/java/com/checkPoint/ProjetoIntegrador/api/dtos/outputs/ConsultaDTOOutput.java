package com.checkPoint.ProjetoIntegrador.api.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConsultaDTOOutput {
    private Integer idConsulta;
    private PacienteDTOOutput paciente;
    private DentistaDTOOutput dentista;
    private LocalDateTime dataHoraConsulta;
}
