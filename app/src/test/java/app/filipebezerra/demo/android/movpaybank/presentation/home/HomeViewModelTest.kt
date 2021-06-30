package app.filipebezerra.demo.android.movpaybank.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.filipebezerra.demo.android.movpaybank.data.BankRepository
import app.filipebezerra.demo.android.movpaybank.data.MovilePayRepository
import app.filipebezerra.demo.android.movpaybank.data.source.BankDataSource
import app.filipebezerra.demo.android.movpaybank.domain.usecase.LoadWidgetsUseCase
import app.filipebezerra.demo.android.movpaybank.presentation.getOrAwaitValue
import app.filipebezerra.demo.android.movpaybank.test.fakes.FakeBankDataSource
import app.filipebezerra.demo.android.movpaybank.test.mocks.MockData
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
        bankDataSource = FakeBankDataSource(MockData.bankWidgets)
        bankRepository = MovilePayRepository(bankDataSource)
        homeViewModel = HomeViewModel(LoadWidgetsUseCase(bankRepository, testCoroutineDispatchers))
    }

    @Test fun observeBankWidgets_obtainsData() = testCoroutineRule.runBlockingTest {
        val expected = MockData.bankWidgets

        assertThat(homeViewModel.bankWidgets.getOrAwaitValue()).isEqualTo(expected)
    }
}