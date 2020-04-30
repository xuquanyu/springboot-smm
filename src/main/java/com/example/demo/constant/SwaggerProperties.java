package com.example.demo.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("demo.swagger")
public class SwaggerProperties {


    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

}
