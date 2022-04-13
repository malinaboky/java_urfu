package com.at2.oslina.di.controller;

import com.at2.oslina.di.service.ConstructorDiService;
import com.at2.oslina.di.service.FieldDiService;
import com.at2.oslina.di.service.ForAutowiredService;
import com.at2.oslina.di.service.SetterDiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class IndexController {
    public final ConstructorDiService constructorDiService;

    @Autowired
    @Qualifier("fieldService")
    public ForAutowiredService fieldDiService;

    public ForAutowiredService setterDiService;

    public IndexController(ConstructorDiService constructorDiService) {
        this.constructorDiService = constructorDiService;
    }

    @Autowired
    public void setSetterDiService(@Qualifier("setterService") ForAutowiredService setterDiService){
        this.setterDiService = setterDiService;
    }

    @GetMapping("/service")
    public List<String> service() {
        Field[] fields = this.getClass().getDeclaredFields();
        return Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());
    }
}
