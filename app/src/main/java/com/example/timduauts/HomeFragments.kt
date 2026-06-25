package com.example.timduauts
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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

        val tvSapaan = view.findViewById<TextView>(R.id.tvSapaan)
        val username = arguments?.getString("username") ?: "Admin"
        tvSapaan.text = "Selamat datang, $username! 👋"

        val ivNotif = view.findViewById<ImageView>(R.id.ivNotif)
        ivNotif?.setOnClickListener {
            val intent = Intent(requireContext(), NotificationActivity::class.java)
            startActivity(intent)
        }

        val tvLihatSemua = view.findViewById<TextView>(R.id.tvLihatSemua)
        tvLihatSemua.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListFragments())
                .commit()
        }

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
                "Tanaman Obat",
                "Tanaman yang efektif menyaring udara.",
                R.drawable.lidah_mertua
            ),
            Tanaman(
                "Kaktus Mini",
                "Tanaman Hias",
                "Tanaman tahan kering yang cantik.",
                R.drawable.kaktus_mini
            )
        )

        rvPopulerHome.layoutManager =
            LinearLayoutManager(requireContext())

        rvPopulerHome.adapter = TanamanAdapter(listTanaman) { tanaman ->
            val intent = Intent(requireContext(), DetailTanamanActivity::class.java)

            intent.putExtra("nama", tanaman.nama)
            intent.putExtra("kategori", tanaman.kategori)
            intent.putExtra("deskripsi", tanaman.deskripsi)
            intent.putExtra("gambar", tanaman.gambar)

            startActivity(intent)
        }

        return view
    }
}