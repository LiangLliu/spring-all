package com.lianglliu.springbootkotlinjunit5.service

import com.lianglliu.springbootkotlinjunit5.domain.Bank
import com.lianglliu.springbootkotlinjunit5.repository.BankRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class BankService(
    @Qualifier("mockBankRepository") private val bankRepository: BankRepository
) {

    fun getBanks(): Collection<Bank> = bankRepository.retrieveBanks()

    fun findBankByAccountNumber(accountNumber: String): Bank = bankRepository.findBankByAccountNumber(accountNumber)

    fun addBank(bank: Bank): Bank = bankRepository.createBank(bank)

    fun updateBank(bank: Bank): Bank = bankRepository.updateBank(bank)

    fun deleteBankByAccountNumber(accountNumber: String) = bankRepository.deleteBankByAccountNumber(accountNumber)
}