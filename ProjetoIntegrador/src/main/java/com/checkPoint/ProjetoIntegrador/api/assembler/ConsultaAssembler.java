package com.checkPoint.ProjetoIntegrador.api.assembler;

import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.ConsultaDTOInput;
import com.checkPoint.ProjetoIntegrador.api.dtos.outputs.ConsultaDTOOutput;
import com.checkPoint.ProjetoIntegrador.domain.model.Consulta;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ConsultaAssembler {

    private ModelMapper modelMapper;

    public ConsultaDTOOutput toConsultaDTOOutput(Consulta consulta){
        return modelMapper.map(consulta, ConsultaDTOOutput.class);
    }

    public List<ConsultaDTOOutput> toCollectionOutput(List<Consulta> consultas){
        return consultas.stream().map(this::toConsultaDTOOutput).collect(Collectors.toList());
    }

    public Consulta toEntity(ConsultaDTOInput consultaDTOInput){
        return modelMapper.map(consultaDTOInput, Consulta.class);
    }
}
