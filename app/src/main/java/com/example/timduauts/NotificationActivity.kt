package com.example.timduauts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        supportActionBar?.hide()

        val rvNotifikasi = findViewById<RecyclerView>(R.id.rvNotifikasi)
        rvNotifikasi.layoutManager = LinearLayoutManager(this)

        val notifikasiList = listOf(
            Notifikasi("Tips Hari Ini 🌱", "Siram tanaman pada pagi hari agar air tidak cepat menguap.", "08:30", "Tips", android.R.drawable.ic_menu_today),
            Notifikasi("Pengingat 🌸", "Bunga Anggrek perlu dipupuk minggu ini.", "Kemarin", "Pengingat", android.R.drawable.ic_dialog_info),
            Notifikasi("Info Tanaman 🍃", "Monstera butuh kelembaban tanah sedang.", "2 hari lalu", "Info", android.R.drawable.ic_menu_agenda),
            Notifikasi("Pengingat 🌵", "Kaktus Mini tidak perlu disiram hari ini.", "3 hari lalu", "Pengingat", android.R.drawable.ic_dialog_alert)
        )

        rvNotifikasi.adapter = NotifikasiAdapter(notifikasiList)
    }
}