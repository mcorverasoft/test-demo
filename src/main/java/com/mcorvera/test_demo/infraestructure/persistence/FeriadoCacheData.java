package com.mcorvera.test_demo.infraestructure.persistence;

import com.mcorvera.test_demo.application.dto.FeriadoResponse;
import com.mcorvera.test_demo.domain.model.Feriados;
import lombok.*;

@EqualsAndHashCode
public class FeriadoCacheData {
    private static Feriados feriado;
    //atributo static para almacenar los feriados del json y asi persistir este valor de una manera simple
    public static void store(Feriados data) {
        feriado = data;
    }

    public static Feriados getFeriados() {
        return feriado;
    }
}
