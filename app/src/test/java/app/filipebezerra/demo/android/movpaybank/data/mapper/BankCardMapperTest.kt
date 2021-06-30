package app.filipebezerra.demo.android.movpaybank.data.mapper

import app.filipebezerra.demo.android.movpaybank.data.api.BankCardDto
import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.test.data.TestData
import app.filipebezerra.demo.android.movpaybank.test.rules.TestCoroutineRule
import app.filipebezerra.demo.android.movpaybank.test.rules.runBlockingTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class BankCardMapperTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private val mapper: Mapper<BankCardDto, BankCard> = BankCardMapper()

    private val bankCard: BankCard = TestData.bankCard
    private val dto: BankCardDto = TestData.bankCardDto

    @Test fun testBankCardEqualsToBankCardDto() = testCoroutineRule.runBlockingTest {
        // Given
        val expected = bankCard

        // When
        val result = mapper.map(dto)

        // Then
        assertThat(result).isEqualTo(expected)
    }
}