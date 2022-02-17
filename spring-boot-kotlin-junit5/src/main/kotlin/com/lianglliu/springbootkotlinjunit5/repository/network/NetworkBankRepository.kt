package com.lianglliu.springbootkotlinjunit5.repository.network

import com.lianglliu.springbootkotlinjunit5.domain.Bank
import com.lianglliu.springbootkotlinjunit5.repository.BankRepository
import org.springframework.stereotype.Repository

@Repository("networkBankRepository")
class NetworkBankRepository(

) : BankRepository {
    override fun retrieveBanks(): Collection<Bank> {
        TODO("Not yet implemented")
    }

    override fun findBankByAccountNumber(accountNumber: String): Bank {
        TODO("Not yet implemented")
    }

    override fun createBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun updateBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun deleteBankByAccountNumber(accountNumber: String) {
        TODO("Not yet implemented")
    }
}