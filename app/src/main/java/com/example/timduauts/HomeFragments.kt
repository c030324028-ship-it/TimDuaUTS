package com.example.timduauts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragments : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.fragment_home,
            container,
            false
        )

        val rvPopulerHome =
            view.findViewById<RecyclerView>(
                R.id.rvPopulerHome
            )

        val listTanaman = listOf(
            Tanaman(
                "Monstera Adansonii",
                "Tanaman Hias",
                "Tanaman populer dengan daun berlubang.",
                R.drawable.monstera_adansonii
            ),
            Tanaman(
                "Lidah Mertua",
                "Tanaman Hias",
                "Tanaman yang efektif menyaring udara.",
                R.drawable.lidah_mertua
            ),
            Tanaman(
                "Kaktus Mini",
                "Kaktus",
                "Tanaman tahan kering yang cantik.",
                R.drawable.kaktus_mini
            )
        )
        rvPopulerHome.layoutManager =
            LinearLayoutManager(requireContext())

        // Bagian ini diperbarui: menambahkan parameter aksi klik
        rvPopulerHome.adapter = TanamanAdapter(listTanaman) { tanaman ->
            // Aksi saat item diklik di halaman Home
            Toast.makeText(context, "Kamu memilih: ${tanaman.nama}", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}