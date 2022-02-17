package com.lianglliu.springbootkotlinjunit5.repository.mock

import com.lianglliu.springbootkotlinjunit5.repository.BankRepository
import com.lianglliu.springbootkotlinjunit5.domain.Bank
import org.springframework.stereotype.Repository

@Repository("mockBankRepository")
class MockBankRepository : BankRepository {

    val banks = mutableListOf(
        Bank("1234", 3.14, 1),
        Bank("1001", 5.9, 2),
        Bank("3453", 7.7, 100),
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun findBankByAccountNumber(accountNumber: String): Bank {
        return banks.firstOrNull() { it -> it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")
    }

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists")
        }

        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = findBankByAccountNumber(bank.accountNumber)
        banks.remove(currentBank)
        banks.add(bank)
        return bank
    }

    override fun deleteBankByAccountNumber(accountNumber: String) {
        val currentBank = findBankByAccountNumber(accountNumber)
        banks.remove(currentBank)
    }
}