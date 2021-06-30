package app.filipebezerra.demo.android.movpaybank.data

import app.filipebezerra.demo.android.movpaybank.data.source.BankDataSource
import app.filipebezerra.demo.android.movpaybank.data.source.remote.InvalidBankCardException
import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import app.filipebezerra.demo.android.movpaybank.test.fakes.FakeBankDataSource
import app.filipebezerra.demo.android.movpaybank.test.data.TestData
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

    private val validCardId = TestData.validCardId
    private val invalidCardId = TestData.invalidCardId

    @Before
    fun setUp() {
        bankDataSource = FakeBankDataSource(
            TestData.bankWidgets,
            "123" to TestData.bankCard
        )
        bankRepository = MovilePayRepository(bankDataSource)
    }

    @Test fun getWidgets_isSucceed() = testCoroutineRule.runBlockingTest {
        // Given
        val expected = TestData.bankWidgets

        // When
        val result = bankRepository.getWidgets().first()

        // Then
        result.assertThatIsEqualTo(expected)
    }

    private fun Result<List<BankWidget>>.assertThatIsEqualTo(expected: List<BankWidget>) {
        assertThatIsSuccessAndEqualTo(expected)
    }

    @Test fun getCard_isSucceed() = testCoroutineRule.runBlockingTest {
        // Given
        val expected = TestData.bankCard

        // When
        val result = bankRepository.getCard(validCardId).first()

        // Then
        result.assertThatIsEqualTo(expected)
    }

    private fun Result<BankCard>.assertThatIsEqualTo(expected: BankCard) {
        assertThatIsSuccessAndEqualTo(expected)
    }

    private fun Result<*>.assertThatIsSuccessAndEqualTo(expected: Any) {
        assertThat(isSuccess).isTrue()
        assertThat(getOrNull()).isNotNull()
        assertThat(getOrNull()).isEqualTo(expected)
    }

    @Test fun getCard_isInvalidCard() = testCoroutineRule.runBlockingTest {
        // When
        val result = bankRepository.getCard(invalidCardId).first()

        // Then
        result.assertThatIsFailureAndExceptionInstanceOf(InvalidBankCardException::class.java)
    }

    private fun Result<*>.assertThatIsFailureAndExceptionInstanceOf(exception: Class<*>) {
        assertThat(isFailure).isTrue()
        assertThat(exceptionOrNull()).isInstanceOf(exception)
    }
}