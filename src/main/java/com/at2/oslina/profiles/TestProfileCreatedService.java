package com.at2.oslina.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@ConditionalOnBean(TestProfileService.class)
public class TestProfileCreatedService {
    Logger logger = LoggerFactory.getLogger(TestProfileCreatedService.class);

    @PostConstruct
    public void init() {
        logger.warn(this.getClass().getName() + " создался...");
    }
}
