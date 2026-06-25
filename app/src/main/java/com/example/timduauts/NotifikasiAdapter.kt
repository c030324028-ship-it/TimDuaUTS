package com.example.timduauts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotifikasiAdapter (private val notifikasiList: List<Notifikasi>) :
    RecyclerView.Adapter<NotifikasiAdapter.NotifikasiViewHolder>() {

    class NotifikasiViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivIconNotif: ImageView = view.findViewById(R.id.ivIconNotif)
        val tvJudulNotif: TextView = view.findViewById(R.id.tvJudulNotif)
        val tvWaktuNotif: TextView = view.findViewById(R.id.tvWaktuNotif)
        val tvDeskripsiNotif: TextView = view.findViewById(R.id.tvDeskripsiNotif)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifikasiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notifikasi, parent, false)
        return NotifikasiViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotifikasiViewHolder, position: Int) {
        val notifikasi = notifikasiList[position]
        holder.ivIconNotif.setImageResource(notifikasi.iconRes)
        holder.tvJudulNotif.text = notifikasi.judul
        holder.tvWaktuNotif.text = notifikasi.waktu
        holder.tvDeskripsiNotif.text = notifikasi.deskripsi
    }

    override fun getItemCount(): Int = notifikasiList.size
}