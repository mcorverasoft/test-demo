package com.mcorvera.test_demo.infraestructure.config;


import com.mcorvera.test_demo.infraestructure.clients.FeriadosClient;
import com.mcorvera.test_demo.infraestructure.persistence.FeriadoCacheData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import(FeignClientsConfiguration.class)
@RequiredArgsConstructor
public class FeriadoCacheInitializer implements CommandLineRunner {

    private final FeriadosClient feriadosClient;

    @Override
    public void run(String... args) throws Exception {
        FeriadoCacheData.store(feriadosClient.getFeriados());
    }
}