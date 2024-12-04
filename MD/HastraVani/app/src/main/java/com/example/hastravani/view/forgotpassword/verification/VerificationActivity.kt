package com.example.hastravani.view.forgotpassword.verification

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hastravani.R

class VerificationActivity : AppCompatActivity() {

    private lateinit var otpEditTexts: Array<EditText>
    private lateinit var btnVerify: AppCompatButton
    private lateinit var btnResend: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        setupViews()
        setupOTPInputs()
        setupListeners()
    }

    private fun setupViews() {
        otpEditTexts = arrayOf(
            findViewById(R.id.otp1),
            findViewById(R.id.otp2),
            findViewById(R.id.otp3),
            findViewById(R.id.otp4),
            findViewById(R.id.otp5),
            findViewById(R.id.otp6)
        )
        btnVerify = findViewById(R.id.btnVerify)
        btnResend = findViewById(R.id.btnResend)

        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            onBackPressed()
        }
    }

    private fun setupOTPInputs() {
        for (i in otpEditTexts.indices) {
            otpEditTexts[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    // Move to next field if current field is filled
                    if (s?.length == 1 && i < otpEditTexts.size - 1) {
                        otpEditTexts[i + 1].requestFocus()
                    }
                    // Move to previous field when backspace is pressed
                    else if (s?.isEmpty() == true && i > 0) {
                        otpEditTexts[i - 1].requestFocus()
                    }

                    validateOTPComplete()
                }
            })

            // Handle backspace key
            otpEditTexts[i].setOnKeyListener { _, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN) {
                    if (otpEditTexts[i].text.isEmpty() && i > 0) {
                        otpEditTexts[i - 1].requestFocus()
                        return@setOnKeyListener true
                    }
                }
                false
            }
        }
    }

    private fun setupListeners() {
        btnVerify.setOnClickListener {
            verifyOTP()
        }

        btnResend.setOnClickListener {
            resendOTP()
        }
    }

    private fun validateOTPComplete() {
        val complete = otpEditTexts.all { it.text.length == 1 }
        btnVerify.isEnabled = complete
    }

    private fun getEnteredOTP(): String {
        return otpEditTexts.joinToString("") { it.text.toString() }
    }

    private fun verifyOTP() {
        val otp = getEnteredOTP()
        // TODO: Implement your OTP verification logic here
        Toast.makeText(this, "Verifying OTP: $otp", Toast.LENGTH_SHORT).show()
    }

    private fun resendOTP() {
        // TODO: Implement your resend OTP logic here
        Toast.makeText(this, "Resending OTP...", Toast.LENGTH_SHORT).show()

        // Clear all fields
        otpEditTexts.forEach { it.text.clear() }
        otpEditTexts[0].requestFocus()
    }
}