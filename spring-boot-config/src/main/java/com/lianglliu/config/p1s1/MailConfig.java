package com.lianglliu.config.p1s1;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailConfig {

    private String hostname;
    private int port;
    private String from;

    private List<String> defaultRecipients;
    private Map<String, Boolean> additionalHeaders;
    private Credentials credentials;
}