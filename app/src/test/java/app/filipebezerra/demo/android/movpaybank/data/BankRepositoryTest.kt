package app.filipebezerra.demo.android.movpaybank.data

import app.filipebezerra.demo.android.movpaybank.data.source.BankDataSource
import app.filipebezerra.demo.android.movpaybank.test.fakes.FakeBankDataSource
import app.filipebezerra.demo.android.movpaybank.test.mocks.MockData
import app.filipebezerra.demo.android.movpaybank.test.rules.TestCoroutineRule
import app.filipebezerra.demo.android.movpaybank.test.rules.runBlockingTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class BankRepositoryTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var bankRepository: BankRepository
    private lateinit var bankDataSource: BankDataSource

    @Before
    fun setUp() {
        bankDataSource = FakeBankDataSource(MockData.bankWidgets)
        bankRepository = MovilePayRepository(bankDataSource)
    }

    @Test
    fun testGetWidgets() = testCoroutineRule.runBlockingTest {
        val expected = MockData.bankWidgets

        val result = bankRepository.getWidgets().first()

        assertThat(result.isSuccess).isTrue()
        assertThat(result.getOrNull()).isNotNull()
        assertThat(result.getOrNull()).isEqualTo(expected)
    }
}