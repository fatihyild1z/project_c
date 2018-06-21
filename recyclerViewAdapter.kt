package com.yildizsoft.fatih.br

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask

import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bumptech.glide.Glide

import com.bumptech.glide.request.RequestOptions

import kotlinx.android.synthetic.main.teksatir_layout.view.*
import java.io.ByteArrayOutputStream

/**
 * Created by Fatih on 14.04.2018.
 */
class recyclerViewAdapter(var context: Context?,var picList:ArrayList<Bitmap>): RecyclerView.Adapter<recyclerViewAdapter.myViewHolder>() {



    override fun getItemCount(): Int {

        return picList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        var oAnOlusturulan=picList.get(position)


        holder.resim.setImageBitmap(oAnOlusturulan)
        Glide.with(holder.itemView.context).load(oAnOlusturulan).apply(RequestOptions().skipMemoryCache(true)).into(holder.resim)
        holder.tekSatirResim.setOnClickListener {

                var intent=Intent(holder.itemView.context,DetayActivity::class.java)

                intent.putExtra("position",position)





                holder.itemView.context.startActivity(intent)

        }

        Log.e("onBindViewHolder","Fonksiyonu")



    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {


        val tekSatirView=LayoutInflater.from(parent.context).inflate(R.layout.teksatir_layout,parent,false)

        return myViewHolder(tekSatirView)
    }




    inner class myViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {
        val tekSatirResim=itemView as CardView
        var resim=tekSatirResim.teksatir_wallpaper







    }





}