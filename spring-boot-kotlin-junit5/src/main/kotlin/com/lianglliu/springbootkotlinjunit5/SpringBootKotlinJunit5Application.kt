package com.lianglliu.springbootkotlinjunit5

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class SpringBootKotlinJunit5Application {

    @Bean
    fun restTemplate(buildr: RestTemplateBuilder): RestTemplate = buildr.build()

}

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinJunit5Application>(*args)
}
