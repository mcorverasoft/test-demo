package com.mcorvera.test_demo.application.inputports;

import com.mcorvera.test_demo.application.dto.FeriadoResponse;
import org.springframework.web.bind.annotation.RequestParam;

public interface FeriadoService {
    FeriadoResponse getFeriados();
    FeriadoResponse getFeriados( String type,String startDate,String endDate);

}
