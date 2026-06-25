package com.example.timduauts
import android.widget.ImageButton
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailTanamanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tanaman)
        val btnBack = findViewById<ImageButton>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

        val imgDetail = findViewById<ImageView>(R.id.imgDetail)
        val tvNamaDetail = findViewById<TextView>(R.id.tvNamaDetail)
        val tvKategoriDetail = findViewById<TextView>(R.id.tvKategoriDetail)
        val tvDeskripsiDetail = findViewById<TextView>(R.id.tvDeskripsiDetail)

        val nama = intent.getStringExtra("nama")
        val kategori = intent.getStringExtra("kategori")
        val deskripsi = intent.getStringExtra("deskripsi")
        val gambar = intent.getIntExtra("gambar", 0)

        tvNamaDetail.text = nama
        tvKategoriDetail.text = kategori
        tvDeskripsiDetail.text = deskripsi

        if (gambar != 0) {
            imgDetail.setImageResource(gambar)
        }
    }
}