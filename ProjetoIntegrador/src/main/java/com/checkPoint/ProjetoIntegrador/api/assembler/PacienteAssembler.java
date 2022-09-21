package com.checkPoint.ProjetoIntegrador.api.assembler;

import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.PacienteDTOInput;
import com.checkPoint.ProjetoIntegrador.api.dtos.outputs.PacienteDTOOutput;
import com.checkPoint.ProjetoIntegrador.domain.model.Paciente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PacienteAssembler {

    private ModelMapper modelMapper;

    public PacienteDTOOutput toDTOOutput(Paciente paciente){
        return modelMapper.map(paciente, PacienteDTOOutput.class);
    }

    public List<PacienteDTOOutput> toCollectionDTOOutput(List<Paciente> pacientes){
        return pacientes.stream().map(this::toDTOOutput).collect(Collectors.toList());
    }

    public Paciente toEntity(PacienteDTOInput pacienteDTOInput){
        return modelMapper.map(pacienteDTOInput, Paciente.class);
    }
}
