package com.checkPoint.ProjetoIntegrador.api.dtos.inputs;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class ConsultaDTOInput {

    @NotNull
    private Integer paciente;

    @NotNull
    private Integer dentista;

    @NotNull
    private LocalDateTime dataHoraConsulta;
}
