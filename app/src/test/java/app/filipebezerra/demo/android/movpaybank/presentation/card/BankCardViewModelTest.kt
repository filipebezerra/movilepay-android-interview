package app.filipebezerra.demo.android.movpaybank.presentation.card

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import app.filipebezerra.demo.android.movpaybank.data.MovilePayRepository
import app.filipebezerra.demo.android.movpaybank.data.source.remote.InvalidBankCardException
import app.filipebezerra.demo.android.movpaybank.domain.model.EmptyBankCard
import app.filipebezerra.demo.android.movpaybank.domain.usecase.GetBankCardUseCase
import app.filipebezerra.demo.android.movpaybank.presentation.getOrAwaitValue
import app.filipebezerra.demo.android.movpaybank.test.data.TestData
import app.filipebezerra.demo.android.movpaybank.test.fakes.FakeBankDataSource
import app.filipebezerra.demo.android.movpaybank.test.rules.TestCoroutineRule
import app.filipebezerra.demo.android.movpaybank.test.rules.runBlockingTest
import app.filipebezerra.demo.android.movpaybank.test.testCoroutineDispatchers
import app.filipebezerra.demo.android.movpaybank.util.CARD_ID_STATE_KEY
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class BankCardViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var viewModel: BankCardViewModel

    private val expected = TestData.bankCard
    private val validCardId = TestData.validCardId
    private val invalidCardId = TestData.invalidCardId

    @Before
    fun setUp() {
        viewModel = createBankCardViewModel()
    }

    @Test fun observeCardDetails_obtainsDetails() = testCoroutineRule.runBlockingTest {
        assertThat(viewModel.cardNumber.getOrAwaitValue()).isEqualTo(expected.cardNumber)
        assertThat(viewModel.cardName.getOrAwaitValue()).isEqualTo(expected.cardName)
        assertThat(viewModel.expirationDate.getOrAwaitValue()).isEqualTo(expected.expirationDate)
    }

    @Test
    fun observeInvalidCardDetails_fail() = testCoroutineRule.runBlockingTest {
        viewModel = createBankCardViewModel(invalidCardId)
        assertThat(viewModel.invalidCardId.getOrAwaitValue()).isTrue()
    }

    private fun createBankCardViewModel(cardId: String? = validCardId) =
        BankCardViewModel(
            savedStateHandle = SavedStateHandle(mapOf(CARD_ID_STATE_KEY to cardId)),
            getBankCardUseCase = createGetBankCardUseCase()
        )

    private fun createGetBankCardUseCase(): GetBankCardUseCase {
        val dataSource = FakeBankDataSource(
            pairOfIdAndBankCard = validCardId to TestData.bankCard
        )
        return GetBankCardUseCase(
            MovilePayRepository(dataSource),
            testCoroutineDispatchers
        )
    }
}