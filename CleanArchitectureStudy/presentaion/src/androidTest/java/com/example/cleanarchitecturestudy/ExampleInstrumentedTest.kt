package com.example.cleanarchitecturestudy

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.cleanarchitecturestudy.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test_espresso() {
        Espresso.onView(withId(R.id.thirdBtn))
            .perform(ViewActions.click())
        Espresso.onView(withId(R.id.et_input))
            .perform(ViewActions.typeText("call"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.et_input))
            .check(matches(withText("call")))
        Espresso.onView(withId(R.id.btn_search))
            .perform(ViewActions.click())
        CountDownLatch(1).await(5, TimeUnit.SECONDS) // Delay
//        Thread.sleep(5000L)
        Espresso.pressBack()
        CountDownLatch(1).await(3, TimeUnit.SECONDS)
        Espresso.onView(withId(R.id.thirdBtn))
            .perform(ViewActions.click())
        Espresso.onView(withId(R.id.et_input))
            .perform(ViewActions.typeText("BED"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.btn_search))
            .perform(ViewActions.click())
        CountDownLatch(1).await(5, TimeUnit.SECONDS)
    }
}