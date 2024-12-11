package com.example.hastravani.view.forgotpassword

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import com.example.hastravani.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var inputLayout: TextInputLayout
    private lateinit var emailPhoneInput: TextInputEditText
    private lateinit var submitButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        // Initialize views
        emailPhoneInput = findViewById(R.id.emailPhoneInput)
        submitButton = findViewById(R.id.submitButton)

        // Set up the toolbar with back button
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Lupa Password"
        }
    }

    private fun setupListeners() {
        // Add text change listener to enable/disable submit button
        emailPhoneInput.doOnTextChanged { text, _, _, _ ->
            submitButton.isEnabled = !text.isNullOrEmpty()

            // Clear error when user starts typing
            inputLayout.error = null
        }

        // Submit button click listener
        submitButton.setOnClickListener {
            handleSubmit()
        }
    }

    private fun handleSubmit() {
        val input = emailPhoneInput.text.toString().trim()

        if (input.isEmpty()) {
            inputLayout.error = "Masukkan email atau nomor telepon"
            return
        }

        // Validate input format
        if (!isValidEmailOrPhone(input)) {
            inputLayout.error = "Format email atau nomor telepon tidak valid"
            return
        }

        // TODO: Implement your password reset logic here
        // For example, call your API to send reset instructions

        // Show loading state
        submitButton.isEnabled = false
        submitButton.text = "Mengirim..."

        // Simulate API call
        submitButton.postDelayed({
            // Reset button state
            submitButton.isEnabled = true
            submitButton.text = "Kirim"

            // Show success message
            Toast.makeText(
                this,
                "Instruksi reset password telah dikirim",
                Toast.LENGTH_LONG
            ).show()

            // Close activity
            finish()
        }, 2000)
    }

    private fun isValidEmailOrPhone(input: String): Boolean {
        // Simple email validation
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        // Simple phone validation (Indonesian format)
        val phonePattern = "^(\\+62|62|0)\\d{9,12}$"

        return input.matches(emailPattern.toRegex()) ||
                input.matches(phonePattern.toRegex())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}