package com.yildizsoft.fatih.br

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Environment
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.teksatir_music.view.*
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import android.os.StatFs
import android.support.v4.content.ContextCompat






class MusicAdapter(var arrayList: ArrayList<String>,var context: Context,var path:ArrayList<String>,var activityKontrol:Int):RecyclerView.Adapter<MusicAdapter.MusicHolder>() {
    lateinit var mediaPlayer:MediaPlayer
    var bytes= arrayOf(1161307,2645992,1235012,3375786,1507814,3467949,1971990,999509,1772315,2942825)

    var length=0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
        val tekSatirView= LayoutInflater.from(parent.context).inflate(R.layout.teksatir_music,parent,false)

        return MusicHolder(tekSatirView)
    }

    override fun getItemCount(): Int {

        return arrayList.size
    }





    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        var oAnOlusturulan=arrayList.get(position)
        var oAnkiPath=path.get(position)
        holder.muzik.text=oAnOlusturulan
        var file=holder.set(oAnkiPath)

        //if (position%2==0){
            //holder.tekSatirMuzik.cardmusic.setCardBackgroundColor(ContextCompat.getColor(context,R.color.colorAccent))
       // }


        if (holder.kontrol(oAnkiPath)){
            holder.tekSatirMuzik.download.visibility=View.INVISIBLE
            holder.tekSatirMuzik.play.visibility=View.VISIBLE
        }
        mediaPlayer=MediaPlayer() // initilaze
        holder.tekSatirMuzik.play.setOnClickListener {
            if (activityKontrol==0){
                length=0
                activityKontrol=1
            }
            else{
                length=mediaPlayer.currentPosition
            }
            if (mediaPlayer.isPlaying){
                mediaPlayer.stop()

            }
            if (holder.tekSatirMuzik.pause.visibility==View.VISIBLE){
                holder.tekSatirMuzik.pause.visibility=View.INVISIBLE
            }

            holder.tekSatirMuzik.play.visibility=View.INVISIBLE
            holder.tekSatirMuzik.pause.visibility=View.VISIBLE
            mediaPlayer=MediaPlayer.create(context, Uri.parse(file.path))
            mediaPlayer.seekTo(length)
            mediaPlayer.start()
        }
        holder.tekSatirMuzik.pause.setOnClickListener {
            mediaPlayer.pause()
            length=mediaPlayer.currentPosition
            Log.e("Length",length.toString())

            holder.tekSatirMuzik.play.visibility=View.VISIBLE
            holder.tekSatirMuzik.pause.visibility=View.INVISIBLE
        }
        holder.tekSatirMuzik.download.setOnClickListener {
            activitymusic().indir(oAnkiPath,context,bytes[position],oAnOlusturulan).execute()
            Log.e(bytes[position].toString(),"position")
            length=0

            holder.tekSatirMuzik.download.visibility=View.INVISIBLE
            holder.tekSatirMuzik.play.visibility=View.VISIBLE


        }
    }


    inner class MusicHolder(itemView: View?):RecyclerView.ViewHolder(itemView){
        val tekSatirMuzik=itemView as CardView
        var muzik=tekSatirMuzik.textSongName

        fun set(child:String): File {
            var path= Environment.getExternalStorageDirectory()
            var dir= File(path,"/save/")
            if(!dir.exists()){
                dir.mkdirs()
            }
            var file=File(dir,child)
            return file
        }

        fun kontrol(child: String): Boolean {
            var path=Environment.getExternalStorageDirectory()



            try {
                var dir=File(path,"/save/")
                if(!dir.exists()){
                    dir.mkdirs()

                }

                var file=File(dir,child)
                var size=file.readBytes().size

                if (file.exists()){


                    return true
                }

            }catch (e: IOException){
                Log.e("hata:",e.toString())
            }catch (ex: FileNotFoundException){
                Log.e("hata2:",ex.toString())
            }

            return false
        }



    }
}