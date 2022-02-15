package com.lianglliu.springbootkotlinjunit5

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/hello")
class HelloWorldController {

    @GetMapping
    fun sayHelloWorld(): String {
        return "Hello, This is a REST endpoint !"
    }
}