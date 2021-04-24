package com.my.demo.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

//配置文件的前缀是"hello"，说明可以解析application.properties中的hello.message
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    //不提供配置的时候的默认值
    private static final String DEFAULT_MSG = "World!";
    private String message = DEFAULT_MSG;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
