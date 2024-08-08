package com.mcorvera.test_demo.domain.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JacksonXmlRootElement(localName = "feriado")
public class Feriado {
    private String date;
    private String title;
    private String type;
    private Boolean inalienable;
    private String extra;
}
