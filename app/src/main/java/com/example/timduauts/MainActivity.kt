package com.example.timduauts

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        if (savedInstanceState == null) {
            tampilkanFragment(HomeFragments())
        }
        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO

        val homeFragment = HomeFragments()
        val bundle = Bundle()
        bundle.putString("username", intent.getStringExtra("username"))
        homeFragment.arguments = bundle


        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    tampilkanFragment(HomeFragments())
                    true
                }

                R.id.menu_plant -> {
                    tampilkanFragment(ListFragments())
                    true
                }

                R.id.menu_profile -> {
                    tampilkanFragment(ProfileFragments())
                    true
                }

                else -> false
            }
        }

    }

    private fun tampilkanFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

    }

    public fun tampilkanDialogLogout() {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Logout")
            .setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")
            .setPositiveButton("Ya") { _, _ ->
                val intentLogout = Intent(this, Login::class.java)
                intentLogout.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intentLogout)
                finish()
            }
            .setNegativeButton("Tidak", null)
            .show()
    }
}