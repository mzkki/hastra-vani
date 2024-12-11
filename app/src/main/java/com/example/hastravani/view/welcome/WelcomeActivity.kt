package com.example.hastravani.view.welcome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hastravani.R
import com.example.hastravani.view.login.LoginActivity
import com.example.hastravani.view.registration.RegisterActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Find the views by their IDs
        val loginButton = findViewById<Button>(R.id.btnMasuk)
        val registerTextView = findViewById<TextView>(R.id.tvRegister)

        // Set click listeners for the buttons
        loginButton.setOnClickListener {
            // Navigate to the login screen
            startActivity(Intent(this, LoginActivity::class.java))
        }

        registerTextView.setOnClickListener {
            // Navigate to the registration screen
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}