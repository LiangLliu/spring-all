package com.lianglliu.springvaultdemo.config.mysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DatabaseConfig {
    private static final String VAULT_DEMO_PATH_NAME = "cubbyhole/mysql";
    private static final String MYSQL_DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true";

    private final VaultTemplate vaultTemplate;

    private Credentials accessCredentials() {
        VaultResponseSupport<Credentials> response = vaultTemplate.read(VAULT_DEMO_PATH_NAME, Credentials.class);
        if (response == null || response.getData() == null) {
            log.error("Fetch Credentials error and Database Credentials is null");
        }

        return response.getData();
    }

    private void initCredentials() {
        Credentials credentials = new Credentials("root", "123456");
        secureCredentials(credentials);
    }

    private void secureCredentials(Credentials credentials) {
        vaultTemplate.write(VAULT_DEMO_PATH_NAME, credentials);
    }

    @Bean
    public DataSource getDataSource() {
        Credentials credentials = accessCredentials();
        System.out.println("========= fetch Credentials =======");
        System.out.println(credentials);
        System.out.println("========= fetch Credentials =======");
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        return DataSourceBuilder.create()
                .url(MYSQL_DB_URL)
                .username(username)
                .password(password)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
