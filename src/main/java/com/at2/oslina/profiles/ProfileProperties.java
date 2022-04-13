package com.at2.oslina.profiles;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@ConstructorBinding
@ConfigurationProperties("prop")
public class ProfileProperties {
    private final String appname;
    private final List<String> list;

    public ProfileProperties(String appname, List<String> list) {
        this.appname = appname;
        this.list = list;
    }

    public String getAppname() {
        return appname;
    }

    public List<String> getList() {
        return list;
    }
}
