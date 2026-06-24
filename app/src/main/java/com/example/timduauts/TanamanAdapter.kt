package com.example.timduauts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TanamanAdapter(
    private val listTanaman: List<Tanaman>
) : RecyclerView.Adapter<TanamanAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val imgTanaman =
            itemView.findViewById<ImageView>(R.id.imgTanaman)

        val tvNamaTanaman =
            itemView.findViewById<TextView>(R.id.tvNamaTanaman)

        val tvKategoriTanaman =
            itemView.findViewById<TextView>(R.id.tvKategoriTanaman)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_tanaman,
                parent,
                false
            )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val tanaman = listTanaman[position]

        holder.tvNamaTanaman.text =
            tanaman.nama

        holder.tvKategoriTanaman.text =
            tanaman.kategori

        holder.imgTanaman.setImageResource(
            tanaman.gambar
        )
    }

    override fun getItemCount(): Int {
        return listTanaman.size
    }
}