package com.example.timduauts

import android.os.Bundle
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
}