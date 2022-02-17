package com.lianglliu.springbootkotlinjunit5.repository

import com.lianglliu.springbootkotlinjunit5.domain.Bank

interface BankRepository {

    fun retrieveBanks(): Collection<Bank>

    fun findBankByAccountNumber(accountNumber: String): Bank

    fun createBank(bank: Bank): Bank

    fun updateBank(bank: Bank): Bank
    fun deleteBankByAccountNumber(accountNumber: String)
}