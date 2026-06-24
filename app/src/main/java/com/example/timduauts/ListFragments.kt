package com.example.timduauts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragments : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_fragments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_tanaman)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val listTanaman = listOf(
            Tanaman("Hydnora Africana", "Tanaman Unik", "Tanaman parasit yang unik.", R.drawable.hydnora_africana),
            Tanaman("Bunga Anggrek", "Tanaman Hias", "Anggrek dengan bunga cantik.", R.drawable.bunga_anggrek_vanda),
            Tanaman("Rafflesia", "Bunga Nasional", "Bunga raksasa yang langka.", R.drawable.rafflesia_arnoldi),
            Tanaman("Sunflower", "Bunga Matahari", "Bunga yang selalu mengikuti matahari.", R.drawable.sunflower),
            Tanaman("Daun Ungu", "Tanaman Obat", "Tanaman dengan daun ungu gelap yang khas.", R.drawable.tanaman_daun_ungu),
            Tanaman("Eceng Gondok", "Tanaman Air", "Tanaman air yang mengapung dengan bunga cantik.", R.drawable.eceng_gondok),
            Tanaman("Tanaman Paku", "Tanaman Hias", "Tanaman hias daun yang sangat klasik.", R.drawable.tanaman_paku),
            Tanaman("Costus Merah", "Tanaman Hias", "Tanaman dengan bunga merah berbentuk kerucut.", R.drawable.costus_merah)
        )

        // Adapter dengan aksi klik
        recyclerView.adapter = TanamanAdapter(listTanaman) { tanaman ->
            Toast.makeText(context, "Kamu memilih: ${tanaman.nama}", Toast.LENGTH_SHORT).show()
        }
    }
}