package com.checkPoint.ProjetoIntegrador.api.dtos.outputs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
public class ConsultaDTOOutput {
    private Integer idConsulta;
    private PacienteDTOOutput pacienteDTOOutput;
    private DentistaDTOOutput dentistaDTOOutput;
    private LocalDateTime dataHoraConsulta;
}
