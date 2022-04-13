package com.at2.oslina.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@EnableConfigurationProperties(ProfileProperties.class)
public class NameAndListService {
    Logger logger = LoggerFactory.getLogger(NameAndListService.class);

    private final ProfileProperties profileProperties;

    public NameAndListService(ProfileProperties profileProperties) {
        this.profileProperties = profileProperties;
    }

    @PostConstruct
    public void init() {
        logger.warn("Application name: " + profileProperties.getAppname());
        logger.warn("Data from property file: " + profileProperties.getList());
    }
}
