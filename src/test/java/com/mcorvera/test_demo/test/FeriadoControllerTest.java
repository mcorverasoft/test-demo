package com.mcorvera.test_demo.test;

import com.mcorvera.test_demo.application.dto.FeriadoResponse;
import com.mcorvera.test_demo.application.inputports.FeriadoService;
import com.mcorvera.test_demo.infraestructure.inputadapters.FeriadoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class FeriadoControllerTest {

    @Mock
    private FeriadoService feriadoService;

    @InjectMocks
    private FeriadoController feriadoController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(feriadoController).build();
    }

    @Test
    void testGetFeriados() throws Exception {
        FeriadoResponse response = new FeriadoResponse();
        when(feriadoService.getFeriados()).thenReturn(response);

        mockMvc.perform(get("/api/feriados")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testGetFeriadosWithFilters() throws Exception {
        FeriadoResponse response = new FeriadoResponse();
        when(feriadoService.getFeriados("Civil", "2024-01-01", "2024-12-31")).thenReturn(response);

        mockMvc.perform(get("/api/feriados/Civil/2024-01-01/2024-12-31")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}