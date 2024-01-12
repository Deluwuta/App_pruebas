package com.example.app_pruebas

import android.content.Context
import androidx.core.content.ContextCompat.getString
import com.example.app_pruebas.model.User
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

private const val FAKE = "Username"
@RunWith(MockitoJUnitRunner::class)
class UsernameUnitTest {
    @Test
    fun username_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Mock
    private lateinit var mockContext: LoginActivity
    @Test
    fun username_label_isCorrect() {
        val mockContext = mock<LoginActivity> {
            on { getString(R.id.et_username) } doReturn FAKE
        }
        assertEquals(FAKE, mockContext.getString(R.id.et_username))
    }
}