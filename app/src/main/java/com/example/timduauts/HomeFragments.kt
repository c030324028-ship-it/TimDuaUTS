package com.example.timduauts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
                R.drawable.monstera_adansonii
            ),

            Tanaman(
                "Lidah Mertua",
                "Tanaman Hias",
                R.drawable.lidah_mertua
            ),

            Tanaman(
                "Kaktus Mini",
                "Kaktus",
                R.drawable.kaktus_mini
            )

        )

        rvPopulerHome.layoutManager =
            LinearLayoutManager(requireContext())

        rvPopulerHome.adapter =
            TanamanAdapter(listTanaman)

        return view
    }
}