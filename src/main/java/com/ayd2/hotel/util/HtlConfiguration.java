package com.ayd2.hotel.util;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HtlConfiguration {

    @Bean
    public Module hibernateModule() {
        return new Hibernate5JakartaModule()
                .enable(Hibernate5JakartaModule.Feature.FORCE_LAZY_LOADING);
    }
}
