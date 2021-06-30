package app.filipebezerra.demo.android.movpaybank.data.mapper

import app.filipebezerra.demo.android.movpaybank.data.api.BankWidgetDto
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import app.filipebezerra.demo.android.movpaybank.test.mocks.MockData
import app.filipebezerra.demo.android.movpaybank.test.rules.TestCoroutineRule
import app.filipebezerra.demo.android.movpaybank.test.rules.runBlockingTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class BankWidgetMapperTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private val mapper: Mapper<BankWidgetDto, BankWidget> = BankWidgetMapper()

    private val firstBankWidget: BankWidget = MockData.bankWidgets.first()
    private val firstDto: BankWidgetDto = MockData.bankWidgetsDto.first()

    @Test fun testBankWidgetsEqualsToBankWidgetsDto() = testCoroutineRule.runBlockingTest {
        val expected = firstBankWidget
        val dto = firstDto

        val result = mapper.map(dto)

        assertThat(result).isEqualTo(expected)
    }
}