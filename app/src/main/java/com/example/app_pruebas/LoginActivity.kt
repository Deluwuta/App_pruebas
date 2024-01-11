package com.example.app_pruebas
import android.os.Bundle
import android.widget.Toast
import com.example.app_pruebas.databinding.LoginScreenBinding
import androidx.appcompat.app.AppCompatActivity
import com.example.app_pruebas.model.User
import com.example.app_pruebas.utils.CredentialCheck

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
    }

    private fun setUpListeners() {
        with(binding) {
            btLogin.setOnClickListener {
                val check = CredentialCheck.login(etUsername.text.toString(), etPassword.text.toString())

                if (check.fail) notifyInvalidCredentials(check.msg)
                else navigateToHomeActivity(
                    User(etUsername.text.toString(), etPassword.text.toString()),
                    check.msg
                )
            }
            btCreateAccount.setOnClickListener {
                Toast.makeText(this@LoginActivity, "Register", Toast.LENGTH_SHORT).show()
                // CreateAccountActivity.start(this@LoginActivity, responseLauncher)
            }
        }
    }

    private fun navigateToHomeActivity(user: User, msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        // HomeActivity.start(this, user)
    }

    private fun notifyInvalidCredentials(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
