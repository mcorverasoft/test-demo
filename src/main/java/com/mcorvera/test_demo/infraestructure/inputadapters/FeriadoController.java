package com.mcorvera.test_demo.infraestructure.inputadapters;

import com.mcorvera.test_demo.application.dto.FeriadoResponse;
import com.mcorvera.test_demo.application.inputports.FeriadoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class FeriadoController {

    private final FeriadoService feriadoService;
    @GetMapping(value="/feriados", produces = {"application/json", "application/xml"})
    public FeriadoResponse getFeriados() {
        log.info("Obteniendo request para obtener todos los feriados");
        FeriadoResponse feriadoResponse = feriadoService.getFeriados();
        log.info("Returning {} feriados", feriadoResponse.getFeriados().size());
        return feriadoResponse;

    }

    @GetMapping(value="/feriados/{type}/{startDate}/{endDate}", produces = {"application/json", "application/xml"})
    public FeriadoResponse getFeriados(
            @PathVariable(value = "type", required = false) String type,
            @PathVariable(value = "startDate", required = false) String startDate,
            @PathVariable(value = "endDate", required = false) String endDate) {
        log.info("Obteniendo Request filtrados por  type: {}, startDate: {}, endDate: {}", type, startDate, endDate);
        FeriadoResponse feriadoResponse = feriadoService.getFeriados(type, startDate, endDate);
        log.info("Returning {} feriados", feriadoResponse.getFeriados().size());
        return  feriadoResponse;
    }
}
