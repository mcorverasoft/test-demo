package com.mcorvera.test_demo.application.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeriadoResponse {
    private String status;
    @JacksonXmlElementWrapper(localName = "feriados")
    @JacksonXmlProperty(localName = "feriado")
    private List<FeriadoDto> feriados;
}
