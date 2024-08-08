package com.mcorvera.test_demo.infraestructure.clients;

import com.mcorvera.test_demo.domain.model.Feriados;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "feriadosClient", url = "${feign.client.feriados.url}")
public interface FeriadosClient {
    @RequestMapping(method = RequestMethod.GET, value ="${feign.client.feriados.endpoint}", consumes = "application/json", produces = "application/json")
    Feriados getFeriados();
}
