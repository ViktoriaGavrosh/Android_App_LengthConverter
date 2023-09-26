package com.viktoriagavrosh.lengthconverter

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun convert_inches_to_cm() {
        onView(withId(R.id.how_much_edit_text))
            .perform(typeText("5"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.centimeters_switch)).perform(click())
        onView(withId(R.id.convert_button)).perform(click())

        onView(withId(R.id.result_centimeters))
            .check(matches(withText(containsString("13"))))
    }

    @Test
    fun convert_inches_to_m() {
        onView(withId(R.id.how_much_edit_text))
            .perform(typeText("125"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.convert_button)).perform(click())

        onView(withId(R.id.result_meters))
            .check(matches(withText(containsString("3"))))
    }

    @Test
    fun convert_feet_to_cm() {
        onView(withId(R.id.how_much_edit_text))
            .perform(typeText("5"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.length_feet)).perform(click())
        onView(withId(R.id.centimeters_switch)).perform(click())
        onView(withId(R.id.convert_button)).perform(click())

        onView(withId(R.id.result_centimeters))
            .check(matches(withText(containsString("152"))))
    }

    @Test
    fun convert_feet_to_m() {
        onView(withId(R.id.how_much_edit_text))
            .perform(typeText("4"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.length_feet)).perform(click())
        onView(withId(R.id.convert_button)).perform(click())

        onView(withId(R.id.result_meters))
            .check(matches(withText(containsString("1"))))
    }

    @Test
    fun convert_yard_to_cm() {
        onView(withId(R.id.how_much_edit_text))
            .perform(typeText("3"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.length_yards)).perform(click())
        onView(withId(R.id.centimeters_switch)).perform(click())
        onView(withId(R.id.convert_button)).perform(click())

        onView(withId(R.id.result_centimeters))
            .check(matches(withText(containsString("274"))))
    }

    @Test
    fun convert_yard_to_m() {
        onView(withId(R.id.how_much_edit_text))
            .perform(typeText("2"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.length_yards)).perform(click())
        onView(withId(R.id.convert_button)).perform(click())

        onView(withId(com.viktoriagavrosh.lengthconverter.R.id.result_meters))
            .check(matches(withText(containsString("1"))))
    }
}