package com.yildizsoft.fatih.br

import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.teksatir_music.view.*
import kotlinx.android.synthetic.main.teksatir_tarih.view.*

class PersonAdapter(var resimler:ArrayList<Int>,var isimler:ArrayList<String>,var yaslar:ArrayList<String>):RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val tekSatirView= LayoutInflater.from(parent.context).inflate(R.layout.teksatir_tarih,parent,false)

        return PersonViewHolder(tekSatirView)    }

    override fun getItemCount(): Int {
        return resimler.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        var oAnOlusturulanResim=resimler.get(position)
        var oAnkiİsim=isimler.get(position)
        var oAnkiyas=yaslar.get(position)
        holder.tarih?.text=oAnkiİsim
        holder.yas?.text=oAnkiyas
        holder.resim?.setImageResource(oAnOlusturulanResim)

        holder.tekSatirTarih.setOnClickListener {
            var intent=Intent(holder.tekSatirTarih.context,tarihikisiler::class.java)
            holder.tekSatirTarih.context.startActivity(intent)
        }
    }


    inner class PersonViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val tekSatirTarih=itemView as CardView
        var tarih=tekSatirTarih.text_name
        var yas=tekSatirTarih.text_age
        val resim=tekSatirTarih.image_tarih
    }
}