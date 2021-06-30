package app.filipebezerra.demo.android.movpaybank.ui.home

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import app.filipebezerra.demo.android.movpaybank.R
import app.filipebezerra.demo.android.movpaybank.test.rules.TestCoroutineRule
import app.filipebezerra.demo.android.movpaybank.test.rules.runBlockingTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@MediumTest
class HomeFragmentTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Test fun test() = testCoroutineRule.runBlockingTest {
        launchFragmentInContainer<HomeFragment>(Bundle(), R.style.Theme_MovPayBank)

        onView(withId(R.id.bank_widgets)).check(matches(isDisplayed()))
    }
}