package com.example.timduauts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class ProfileFragments : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.fragment_profile,
            container,
            false
        )

        val layoutTentang = view.findViewById<LinearLayout>(R.id.layoutTentang)
        val detailTentang = view.findViewById<LinearLayout>(R.id.detailTentang)
        val iconTentang = view.findViewById<ImageView>(R.id.iconTentang)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)

        layoutTentang.setOnClickListener {

            if (detailTentang.visibility == View.GONE) {
                detailTentang.visibility = View.VISIBLE
                iconTentang.rotation = 180f
            } else {
                detailTentang.visibility = View.GONE
                iconTentang.rotation = 0f
            }

        }

        val layoutAnggota = view.findViewById<LinearLayout>(R.id.layoutAnggota)
        val detailAnggota = view.findViewById<LinearLayout>(R.id.detailAnggota)
        val iconAnggota = view.findViewById<ImageView>(R.id.iconAnggota)

        layoutAnggota.setOnClickListener {

            if (detailAnggota.visibility == View.GONE) {
                detailAnggota.visibility = View.VISIBLE
                iconAnggota.rotation = 180f
            } else {
                detailAnggota.visibility = View.GONE
                iconAnggota.rotation = 0f
            }

        }

        val layoutCredits = view.findViewById<LinearLayout>(R.id.layoutCredits)
        val detailCredits = view.findViewById<LinearLayout>(R.id.detailCredits)
        val iconCredits = view.findViewById<ImageView>(R.id.iconCredits)

        layoutCredits.setOnClickListener {

            if (detailCredits.visibility == View.GONE) {
                detailCredits.visibility = View.VISIBLE
                iconCredits.rotation = 180f
            } else {
                detailCredits.visibility = View.GONE
                iconCredits.rotation = 0f
            }

        }

        btnLogout.setOnClickListener {
            (activity as? MainActivity)?.tampilkanDialogLogout()
        }

        return view
    }

}