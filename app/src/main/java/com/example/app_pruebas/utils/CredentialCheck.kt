package com.example.app_pruebas.utils

class CredentialCheck private constructor() {
    var fail: Boolean = false
    var msg: String = ""
    var error: CredentialError = CredentialError.PasswordError

    companion object {
        private val TAG = CredentialCheck::class.java.canonicalName
        private val MINCHARS = 4
        private val PASSWORD_PATTERN = Regex(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
        )

        private val checks = arrayOf (
            CredentialCheck().apply {
                fail = false
                msg = "Your credentials are OK"
                error = CredentialError.Success
            },
            CredentialCheck().apply {
                fail = true
                msg = "Invalid username"
                error = CredentialError.UsernameError
            },
            CredentialCheck().apply {
                fail = true
                msg = "Invalid password"
                error = CredentialError.PasswordError
            },
            CredentialCheck().apply {
                fail = true
                msg = "Passwords do not match"
                error = CredentialError.PasswordError
            }
        )

        fun login(username: String, password: String) : CredentialCheck
        {
            // Testing
            return checks[0]

            //return if (username.isBlank())
            //    checks[1] // UsernameError
            //else if (password.isBlank())
            //    checks[2] // PasswordError
            //else checks[0]
        }

        fun createAccount(username: String, password: String, repassword: String) : CredentialCheck
        {
            return if (username.isBlank() || username.length < MINCHARS)
                checks[1] // UsernameError
            else if (password.isBlank() || !PASSWORD_PATTERN.matches(password))
                checks[2] // PasswordError
            else if (password != repassword)
                checks[3] // PasswordError
            else checks[0]
        }
    }
}

enum class CredentialError {
    PasswordError, UsernameError, Success
}
