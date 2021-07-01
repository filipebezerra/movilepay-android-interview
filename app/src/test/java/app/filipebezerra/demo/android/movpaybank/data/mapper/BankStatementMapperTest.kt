package app.filipebezerra.demo.android.movpaybank.data.mapper

import app.filipebezerra.demo.android.movpaybank.data.api.BankStatementDto
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.test.data.TestData
import app.filipebezerra.demo.android.movpaybank.test.rules.TestCoroutineRule
import app.filipebezerra.demo.android.movpaybank.test.rules.runBlockingTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class BankStatementMapperTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private val mapper: Mapper<BankStatementDto, BankStatement> =
        BankStatementMapper(BankTransactionMapper())

    private val expected: BankStatement = TestData.bankStatement
    private val dto: BankStatementDto = TestData.bankStatementDto

    @Test fun testBankStatementEqualsToBankStatementDto() = testCoroutineRule.runBlockingTest {
        // When
        val result = mapper.map(dto)

        // Then
        assertThat(result).isEqualTo(expected)
    }
}