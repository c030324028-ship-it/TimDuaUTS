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

        val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("IS_LOGGED_IN", false)

        if (isLoggedIn) {
            val savedName = sharedPref.getString("LOGGED_USERNAME", "Admin")
            val intentDirect = Intent(this, MainActivity::class.java)
            intentDirect.putExtra("username", savedName)
            startActivity(intentDirect)
            finish()
            return
        }

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

        // Membuat akun dummy default awal jika belum ada
        val editor = sharedPref.edit()
        if (!sharedPref.contains("USERNAME")) {
            editor.putString("USERNAME", "admin")
            editor.putString("PASSWORD", "12345")
            editor.apply()
        }

        tvDaftar.setOnClickListener {
            startActivity(Intent(this, Daftar::class.java))
        }

        btnLogin.setOnClickListener {
            val inputUsername = etUsernameLogin.text.toString()
            val inputPassword = etPasswordLogin.text.toString()

            val registeredUsername = sharedPref.getString("USERNAME", "admin")
            val registeredPassword = sharedPref.getString("PASSWORD", "12345")

            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(this, "Username atau Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            }
            else if ((inputUsername == registeredUsername && inputPassword == registeredPassword) ||
                (inputUsername == "admin" && inputPassword == "12345")) {

                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()

                val namaTampil = if (inputUsername == "admin") "Admin" else inputUsername

                val loginEditor = sharedPref.edit()
                loginEditor.putBoolean("IS_LOGGED_IN", true)
                loginEditor.putString("LOGGED_USERNAME", namaTampil) // Simpan nama untuk sapaan di Home
                loginEditor.apply()

                val intentLogin = Intent(this, MainActivity::class.java)
                intentLogin.putExtra("username", namaTampil)
                startActivity(intentLogin)
                finish()
            } else {
                Toast.makeText(this, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}