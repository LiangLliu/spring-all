package com.lianglliu.springbootkotlinjunit5.repository

import com.lianglliu.springbootkotlinjunit5.model.Bank

interface BankRepository {

    fun retrieveBanks(): Collection<Bank>
    fun findBankByAccountNumber(accountNumber: String): Bank
}