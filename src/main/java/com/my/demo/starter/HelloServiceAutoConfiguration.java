package com.my.demo.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix = "hello", name = "enabled", havingValue = "true", matchIfMissing = false)
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloServiceProperties helloServiceProperties;

    @Bean
    //当没有HelloService这中Bean的时候，就创建这个Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService helloService() {
        //用配置中的Message创建一个对象
        HelloService helloService = new HelloService();
        helloService.setMessage(helloServiceProperties.getMessage());
        return helloService;
    }
}
