package com.at2.oslina.di.config;

import com.at2.oslina.di.service.FieldDiService;
import com.at2.oslina.di.service.SetterDiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public FieldDiService fieldService() {
        return new FieldDiService();
    }

    @Bean
    public SetterDiService setterService() {
        return new SetterDiService();
    }
}
