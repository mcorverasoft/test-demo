package com.mcorvera.test_demo.application.service;

import com.mcorvera.test_demo.application.dto.FeriadoDto;
import com.mcorvera.test_demo.application.dto.FeriadoResponse;
import com.mcorvera.test_demo.application.inputports.FeriadoService;
import com.mcorvera.test_demo.domain.model.Feriado;
import com.mcorvera.test_demo.domain.model.Feriados;
import com.mcorvera.test_demo.infraestructure.persistence.FeriadoCacheData;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeriadoServiceImpl implements FeriadoService {

    private final ModelMapper modelMapper;

    @Override
    public FeriadoResponse getFeriados() {
        return modelMapper.map(FeriadoCacheData.getFeriados(), FeriadoResponse.class);
    }

    @Override
    public FeriadoResponse getFeriados(String type, String startDate, String endDate) {
        //Primero obtener los feriados filtrados por tipy, startDate y endDate
        List<Feriado> feriadoFilters =FeriadoCacheData.getFeriados().getData().stream()
                .filter(f -> (f.getType().toLowerCase().equals(type.toLowerCase())) &&
                        (f.getDate().compareTo(startDate) >= 0) &&
                        (f.getDate().compareTo(endDate) <= 0))
                .collect(Collectors.toList());
        //Se retorna un objeto Feriados con los feriados filtrados
        Feriados feriadosResponse= Feriados.builder().status(FeriadoCacheData.getFeriados().getStatus()).data(feriadoFilters).build();
        return modelMapper.map(feriadosResponse, FeriadoResponse.class);
    }
}
