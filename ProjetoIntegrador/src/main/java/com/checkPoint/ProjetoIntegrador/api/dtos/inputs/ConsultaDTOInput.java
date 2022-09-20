package com.checkPoint.ProjetoIntegrador.api.dtos.inputs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ConsultaDTOInput {
    private Integer idPaciente;
    private Integer idDentista;
    private LocalDateTime dataHoraConsulta;
}
