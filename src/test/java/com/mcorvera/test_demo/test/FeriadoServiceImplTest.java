package com.mcorvera.test_demo.test;

import com.mcorvera.test_demo.application.dto.FeriadoResponse;
import com.mcorvera.test_demo.application.inputports.FeriadoService;
import com.mcorvera.test_demo.domain.model.Feriado;
import com.mcorvera.test_demo.domain.model.Feriados;
import com.mcorvera.test_demo.infraestructure.persistence.FeriadoCacheData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FeriadoServiceImplTest {

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private FeriadoService feriadoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        FeriadoCacheData.store(new Feriados("success", getMockFeriados()));
    }

    @Test
    void testGetFeriados() {
        Feriados feriados = new Feriados("success", getMockFeriados());
        FeriadoResponse response = new FeriadoResponse();
        when(modelMapper.map(feriados, FeriadoResponse.class)).thenReturn(response);

        FeriadoResponse result = feriadoService.getFeriados();
        assertEquals(response, result);
    }

    @Test
    void testGetFeriadosWithFilters() {
        List<Feriado> filteredFeriados = getMockFeriados();
        Feriados filteredResponse = new Feriados("success", filteredFeriados);
        FeriadoResponse response = new FeriadoResponse();
        when(modelMapper.map(filteredResponse, FeriadoResponse.class)).thenReturn(response);

        FeriadoResponse result = feriadoService.getFeriados("Civil", "2024-01-01", "2024-12-31");
        assertEquals(response, result);
    }

    private List<Feriado> getMockFeriados() {
        return Arrays.asList(
                new Feriado("2024-01-01", "Año Nuevo", "Civil", true, "Civil e Irrenunciable"),
                new Feriado("2024-03-29", "Viernes Santo", "Religioso", false, "Religioso")
        );
    }
}