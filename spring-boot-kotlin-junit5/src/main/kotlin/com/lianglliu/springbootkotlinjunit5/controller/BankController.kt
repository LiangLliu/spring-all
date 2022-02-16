package com.lianglliu.springbootkotlinjunit5.controller

import com.lianglliu.springbootkotlinjunit5.model.Bank
import com.lianglliu.springbootkotlinjunit5.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(private val bankService: BankService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAllBanks(): Collection<Bank> = bankService.getBanks()
}