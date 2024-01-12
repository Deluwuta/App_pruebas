package com.example.app_pruebas

import android.service.autofill.Validators.not
import androidx.core.content.ContextCompat.startActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.google.android.material.internal.ContextUtils.getActivity

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
@LargeTest
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.app_pruebas", appContext.packageName)
    }

    // Se crea un objeto de tipo LoginActivity
    @get:Rule
    val activityTestRule = ActivityScenarioRule(LoginActivity::class.java)
    @Test
    fun login_isCorrect() {
        // Start login activity
        onView(withId(R.id.et_username)).perform(typeText("Trojes"))
        // Hacemos que presione el boton atras de Android
        pressBack()
        onView(withId(R.id.et_password)).perform(typeText("123456"))
        //pressBack()
        onView(withId(R.id.et_username)).check(matches(withText("Trojes")))
    }
}