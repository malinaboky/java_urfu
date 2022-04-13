package com.at2.oslina.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Profile("test")
public class TestProfileService {
    Logger logger = LoggerFactory.getLogger(TestProfileService.class);

    @PostConstruct
    public void init() {
        logger.warn(this.getClass().getName() + " создался...");
    }
}
