package com.lianglliu.springbootkotlinjunit5.controller

import com.lianglliu.springbootkotlinjunit5.model.Bank
import com.lianglliu.springbootkotlinjunit5.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(private val bankService: BankService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun bankHandleNotFound(exception: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(exception.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun bankHandleNotFound(exception: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(exception.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAllBanks(): Collection<Bank> = bankService.getBanks()

    @GetMapping("/{accountNumber}")
    @ResponseStatus(HttpStatus.OK)
    fun findBankByAccountNumber(@PathVariable("accountNumber") accountNumber: String) =
        bankService.findBankByAccountNumber(accountNumber)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addBank(@RequestBody bank: Bank): Bank = bankService.addBank(bank)
}