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

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        enableEdgeToEdge()
        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUsernameLogin = findViewById<EditText>(R.id.etUsernameLogin)
        val etPasswordLogin = findViewById<EditText>(R.id.etPasswordLogin)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvDaftar = findViewById<TextView>(R.id.tvDaftar)

        tvDaftar.setOnClickListener {
            startActivity(Intent(this, Daftar::class.java))
        }

        btnLogin.setOnClickListener {
            val inputUsername = etUsernameLogin.text.toString()
            val inputPassword = etPasswordLogin.text.toString()
            val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
            val registeredUsername = sharedPref.getString("USERNAME", "")
            val registeredPassword = sharedPref.getString("PASSWORD", "")

            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(this, "Username atau Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            }

            else if ((inputUsername == registeredUsername && inputPassword == registeredPassword) ||
                (inputUsername == "admin" && inputPassword == "12345")) {

                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()

                val namaTampil = if (inputUsername == "admin") {
                    "Admin"
                } else {
                    inputUsername
                }

                val intentLogin = Intent(this, MainActivity::class.java)
                intentLogin.putExtra("username", namaTampil)
                startActivity(intentLogin)
                finish()
            }
        }
    }
}
