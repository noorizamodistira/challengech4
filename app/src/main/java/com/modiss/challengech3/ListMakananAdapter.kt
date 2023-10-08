package com.modiss.challengech3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListMakananAdapter(
    private val listMakanan: ArrayList<Makanan>,
    private val onClick: (Makanan) -> Unit) : RecyclerView.Adapter<ListMakananAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_makanan, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, harga, photo) = listMakanan[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.ivPhotoCatalog)

        holder.tvNamaMakanan.text = nama
        holder.tvHargaMakanan.text = harga

        holder.itemView.setOnClickListener {
            onClick(listMakanan[position])
        }
    }

    override fun getItemCount(): Int = listMakanan.size


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPhotoCatalog: ImageView = itemView.findViewById(R.id.iv_photo_catalog)
        val tvNamaMakanan: TextView = itemView.findViewById(R.id.tv_nama_makanan)
        val tvHargaMakanan: TextView = itemView.findViewById(R.id.tv_harga_makanan)

    }
}