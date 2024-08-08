package com.mcorvera.test_demo.domain.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@JacksonXmlRootElement(localName = "feriado")
public class Feriados {
    private String status;
    private List<Feriado> data;
}
