package com.checkPoint.ProjetoIntegrador.api.assembler;

import com.checkPoint.ProjetoIntegrador.api.dtos.inputs.DentistaDTOInput;
import com.checkPoint.ProjetoIntegrador.api.dtos.outputs.DentistaDTOOutput;
import com.checkPoint.ProjetoIntegrador.domain.model.Dentista;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DentistaAssembler {

    private ModelMapper modelMapper;

    public DentistaDTOOutput toDentistaDTOOutput(Dentista dentista){
        return modelMapper.map(dentista, DentistaDTOOutput.class);
    }

    public List<DentistaDTOOutput> toCollectionOutput(List<Dentista> dentistas){
        return dentistas.stream().map(this::toDentistaDTOOutput).collect(Collectors.toList());
    }

    public Dentista toEntity(DentistaDTOInput dentistaDTOInput){
        return modelMapper.map(dentistaDTOInput, Dentista.class);
    }
}
