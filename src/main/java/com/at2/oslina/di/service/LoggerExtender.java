package com.at2.oslina.di.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LoggerExtender {
    Logger logger = LoggerFactory.getLogger(LoggerExtender.class);

    @PostConstruct
    public void init() {
        logger.warn("Пораждается " + this.getClass().getName());
    }

    @PreDestroy
    public void destroy() {
        logger.warn("Уничтожается " + this.getClass().getName());
    }
}
