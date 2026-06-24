package com.example.timduauts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TanamanAdapter(
    private val listTanaman: List<Tanaman>,
    private val onItemClick: (Tanaman) -> Unit // Parameter baru untuk menangkap aksi klik
) : RecyclerView.Adapter<TanamanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tanaman, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tanaman = listTanaman[position]

        holder.tvNama.text = tanaman.nama
        holder.tvKategori.text = tanaman.kategori
        holder.tvDeskripsi.text = tanaman.deskripsi
        holder.imgTanaman.setImageResource(tanaman.gambar)

        // Logika klik dipasang di sini
        holder.itemView.setOnClickListener {
            onItemClick(tanaman)
        }
    }

    override fun getItemCount(): Int {
        return listTanaman.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgTanaman: ImageView = itemView.findViewById(R.id.imgTanaman)
        val tvNama: TextView = itemView.findViewById(R.id.tvNamaTanaman)
        val tvKategori: TextView = itemView.findViewById(R.id.tvKategoriTanaman)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.tvDeskripsiTanaman)
    }
}