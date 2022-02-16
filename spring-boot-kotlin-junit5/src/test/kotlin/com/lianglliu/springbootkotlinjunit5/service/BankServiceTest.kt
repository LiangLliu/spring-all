package com.lianglliu.springbootkotlinjunit5.service

import com.lianglliu.springbootkotlinjunit5.repository.BankRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    private val bankRepository: BankRepository = mockk(relaxed = true)
    private val bankService = BankService(bankRepository)

    @Test
    fun `should call its repository to retrieve banks`() {
        // when
        val banks = bankService.getBanks()

        // then
        verify(exactly = 1) { bankRepository.retrieveBanks() }
    }
}