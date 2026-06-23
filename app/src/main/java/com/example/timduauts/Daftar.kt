package com.example.timduauts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Daftar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        enableEdgeToEdge()
        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO

        setContentView(R.layout.activity_daftar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNamaLengkap = findViewById<EditText>(R.id.etNamaLengkap)
        val etUsernameDaftar = findViewById<EditText>(R.id.etUsernameDaftar)
        val etPasswordDaftar = findViewById<EditText>(R.id.etPasswordDaftar)
        val etKonfirmasiPassword = findViewById<EditText>(R.id.etKonfirmasiPassword)
        val btnDaftar = findViewById<Button>(R.id.btnDaftar)
        val tvLogin = findViewById<TextView>(R.id.tvLogin)

        tvLogin.setOnClickListener {
            finish()
        }

        btnDaftar.setOnClickListener {
            val namaLengkap = etNamaLengkap.text.toString()
            val username = etUsernameDaftar.text.toString()
            val password = etPasswordDaftar.text.toString()
            val konfirmasiPassword = etKonfirmasiPassword.text.toString()

            when {
                namaLengkap.isEmpty() || username.isEmpty() || password.isEmpty() || konfirmasiPassword.isEmpty() -> {
                    Toast.makeText(this, "Semua data wajib diisi", Toast.LENGTH_SHORT).show()
                }
                password != konfirmasiPassword -> {
                    Toast.makeText(this, "Password tidak sama", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
                    sharedPref.edit()
                        .putString("USERNAME", username)
                        .putString("PASSWORD", password)
                        .apply()

                    Toast.makeText(this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}