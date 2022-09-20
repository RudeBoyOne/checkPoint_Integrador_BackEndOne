package com.checkPoint.ProjetoIntegrador.api.dtos;

import com.checkPoint.ProjetoIntegrador.domain.model.Consulta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaDTO {
    private String nomeCompletoDentista;
    private String nomeCompletoPaciente;
    private LocalDateTime dataConsulta;

    public ConsultaDTO toConsultaDTO(Consulta consulta){
        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setNomeCompletoDentista(consulta.getDentista().getNome()+
                " "+consulta.getDentista().getSobrenome());
        consultaDTO.setNomeCompletoPaciente(consulta.getPaciente().getNome()+
                " "+consulta.getPaciente().getSobrenome());
        consultaDTO.setDataConsulta(consulta.getDataHoraConsulta());
        return consultaDTO;
    }
}
