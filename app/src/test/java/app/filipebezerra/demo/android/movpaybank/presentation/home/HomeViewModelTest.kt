package app.filipebezerra.demo.android.movpaybank.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.filipebezerra.demo.android.movpaybank.data.BankRepository
import app.filipebezerra.demo.android.movpaybank.data.MovilePayRepository
import app.filipebezerra.demo.android.movpaybank.data.source.BankDataSource
import app.filipebezerra.demo.android.movpaybank.domain.usecase.LoadBankWidgetsUseCase
import app.filipebezerra.demo.android.movpaybank.presentation.getOrAwaitValue
import app.filipebezerra.demo.android.movpaybank.test.fakes.FakeBankDataSource
import app.filipebezerra.demo.android.movpaybank.test.data.TestData
import app.filipebezerra.demo.android.movpaybank.test.rules.TestCoroutineRule
import app.filipebezerra.demo.android.movpaybank.test.rules.runBlockingTest
import app.filipebezerra.demo.android.movpaybank.test.testCoroutineDispatchers
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var bankDataSource: BankDataSource
    private lateinit var bankRepository: BankRepository
    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        bankDataSource = FakeBankDataSource(TestData.bankWidgets)
        bankRepository = MovilePayRepository(bankDataSource)
        homeViewModel = HomeViewModel(LoadBankWidgetsUseCase(bankRepository, testCoroutineDispatchers))
    }

    @Test fun observeBankWidgets_obtainsData() = testCoroutineRule.runBlockingTest {
        val expected = TestData.bankWidgets

        assertThat(homeViewModel.bankWidgets.getOrAwaitValue()).isEqualTo(expected)
    }
}