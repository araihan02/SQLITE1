package com.ahmadraihan.sqlite1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DBAdapter(private val listDataku: ArrayList<DBModel>): RecyclerView.Adapter<DBAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemV: View): RecyclerView.ViewHolder(itemV) {
        var tvemailku: TextView = itemV.findViewById(R.id.tv_emailku)
        var tvnamaku: TextView = itemV.findViewById(R.id.tv_namaku)
        var tvalamatku: TextView = itemV.findViewById(R.id.tv_alamatku)
        var tvjkku: TextView = itemV.findViewById(R.id.tv_jkku)
        var tvteleponku: TextView = itemV.findViewById(R.id.tv_teleponku)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_dataku, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvemailku.text = dataku.email
        holder.tvnamaku.text = dataku.nama
        holder.tvalamatku.text = dataku.alamat
        holder.tvjkku.text = dataku.jk
        holder.tvteleponku.text = dataku.telepon

    }

    override fun getItemCount(): Int {
        return listDataku.size
    }
}