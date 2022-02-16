package com.lianglliu.springbootkotlinjunit5.service

import com.lianglliu.springbootkotlinjunit5.model.Bank
import com.lianglliu.springbootkotlinjunit5.repository.BankRepository
import org.springframework.stereotype.Service

@Service
class BankService(private val bankRepository: BankRepository) {

    fun getBanks(): Collection<Bank> = bankRepository.retrieveBanks()

    fun findBankByAccountNumber(accountNumber: String): Bank = bankRepository.findBankByAccountNumber(accountNumber)
}