package com.lianglliu.springbootkotlinjunit5.repository.mock

import com.lianglliu.springbootkotlinjunit5.repository.BankRepository
import com.lianglliu.springbootkotlinjunit5.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankRepository : BankRepository {

    val banks = listOf(
            Bank("1234", 3.14, 1),
            Bank("1001", 5.9, 2),
            Bank("3453", 7.7, 100),
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun findBankByAccountNumber(accountNumber: String): Bank {
        return banks.firstOrNull() { it -> it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")
    }
}