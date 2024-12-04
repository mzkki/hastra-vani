package com.example.hastravani.view.forgotpassword.newpassword

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hastravani.R

class NewPasswordActivity : AppCompatActivity() {

    private lateinit var etNewPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnSave: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_password)

        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        etNewPassword = findViewById(R.id.etNewPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnSave = findViewById(R.id.btnSave)

        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            onBackPressed()
        }
    }

    private fun setupListeners() {
        // Enable/disable save button based on input validity
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                validateInputs()
            }
        }

        etNewPassword.addTextChangedListener(textWatcher)
        etConfirmPassword.addTextChangedListener(textWatcher)

        btnSave.setOnClickListener {
            if (validatePasswords()) {
                saveNewPassword()
            }
        }
    }

    private fun validateInputs() {
        val newPass = etNewPassword.text.toString()
        val confirmPass = etConfirmPassword.text.toString()

        btnSave.isEnabled = newPass.isNotEmpty() && confirmPass.isNotEmpty()
    }

    private fun validatePasswords(): Boolean {
        val newPass = etNewPassword.text.toString()
        val confirmPass = etConfirmPassword.text.toString()

        // Check password length
        if (newPass.length < 6) {
            etNewPassword.error = "Password minimal 6 karakter"
            return false
        }

        // Check if passwords match
        if (newPass != confirmPass) {
            etConfirmPassword.error = "Password tidak cocok"
            return false
        }

        return true
    }

    private fun saveNewPassword() {
        val newPassword = etNewPassword.text.toString()

        // TODO: Implement your password saving logic here
        // For example, API call to update password

        // Show loading state
        btnSave.isEnabled = false
        btnSave.text = "Menyimpan..."

        // Simulate API call
        Handler(Looper.getMainLooper()).postDelayed({
            // Show success message
            Toast.makeText(
                this,
                "Password berhasil diperbarui",
                Toast.LENGTH_SHORT
            ).show()

            // Navigate back or to login screen
            finish()
        }, 1500)
    }
}