package com.edwin.dubbo.server;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboServerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboServerProviderApplication.class, args);
    }

}
