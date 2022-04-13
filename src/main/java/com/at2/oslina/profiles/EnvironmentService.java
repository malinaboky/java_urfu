package com.at2.oslina.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@ConditionalOnExpression("'${prop.environment}' != 'default'")
public class EnvironmentService {
    Logger logger = LoggerFactory.getLogger(EnvironmentService.class);

    @PostConstruct
    public void init() {
        logger.warn(this.getClass().getName() + " создался...");
    }
}
