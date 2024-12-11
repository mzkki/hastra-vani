package com.example.hastravani.view.registration

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.hastravani.databinding.ActivityRegistrationBinding
import com.example.hastravani.view.main.MainActivity
import com.example.hastravani.view.TermsActivity.TermsActivity
import com.example.hastravani.view.ViewModelFactory
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var auth: FirebaseAuth

    private val registrationViewModel by viewModels<RegistrationViewModel>{
        ViewModelFactory.getInstance(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        setupClickListeners()
    }


    private fun setupClickListeners() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        binding.tvTerms.setOnClickListener {
            // Navigate to Terms and Conditions
            startActivity(Intent(this, TermsActivity::class.java))
        }

        binding.btnRegister.setOnClickListener {
            validateAndRegister()
        }
    }

    private fun validateAndRegister() {
        val fullName = binding.edtFullName.text.toString()
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        val phone = binding.edtPhone.text.toString()
        val isTermsAccepted = binding.cbTerms.isChecked

        // Reset errors
        binding.tilFullName.error?: null
        binding.tilEmail.error?: null
        binding.tilPassword.error?: null
        binding.tilPhone.error?: null

        when {
            fullName.isEmpty() -> {
                binding.tilFullName.error?: "Nama lengkap tidak boleh kosong"
                return
            }
            email.isEmpty() -> {
                binding.tilEmail.error?: "Email tidak boleh kosong"
                return
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                binding.tilEmail.error?: "Format email tidak valid"
                return
            }
            password.isEmpty() -> {
                binding.tilPassword.error?: "Password tidak boleh kosong"
                return
            }
            password.length < 8 -> {
                binding.tilPassword.error?: "Password minimal 8 karakter"
                return
            }
            phone.isEmpty() -> {
                binding.tilPhone.error?: "Nomor telepon tidak boleh kosong"
                return
            }
            !isTermsAccepted -> {
                Toast.makeText(this, "Anda harus menyetujui syarat dan ketentuan", Toast.LENGTH_SHORT).show()
                return
            }
        }

        // If all validations pass, proceed with registration
        showLoading(true)
        registerUser(fullName, email, password, phone)
    }

    private fun registerUser(fullName: String, email: String, password: String, phone: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Registration success
                    val user = auth.currentUser

                    // Create user profile
                    val userProfile = hashMapOf(
                        "fullName" to fullName,
                        "email" to email,
                        "phone" to phone,
                        "createdAt" to FieldValue.serverTimestamp()
                    )

                    // Save user profile to Firestore
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user?.uid ?: "")
                        .set(userProfile)
                        .addOnSuccessListener {
                            showLoading(false)
                            Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, MainActivity::class.java))
                            finishAffinity()
                        }
                        .addOnFailureListener { e ->
                            showLoading(false)
                            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                } else {
                    // If registration fails, display a message to the user
                    showLoading(false)
                    Toast.makeText(this, "Registrasi gagal: ${task.exception?.message}",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.btnRegister.isEnabled!= isLoading
    }
}