package com.yildizsoft.fatih.br

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.fragment_bildirim.*
import kotlinx.android.synthetic.main.progress.*
import kotlinx.android.synthetic.main.progress.view.*

class activity_menu : AppCompatActivity() {
    var resimler=ArrayList<Bitmap>()
    var isPaused=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        var size=intent.getIntExtra("size",0)
        Log.e("sayi",size.toString())
        progresswall.visibility= View.INVISIBLE
        progressmusic.visibility=View.INVISIBLE

       // var anim11= AnimationUtils.loadAnimation(this,R.anim.wave)
        // zil.animation=anim11
        cardwall.setOnClickListener {
            progresswall.visibility= View.VISIBLE
            duvaricon.visibility=View.INVISIBLE
            Handler().postDelayed({   var intent=Intent(this,activity_wallpaper::class.java)



                this.startActivity(intent)},1000)



        }
       // zil.setOnClickListener {
         //   var dialog=bildirim()
           // dialog.show(supportFragmentManager,"indirmde")

        //}

        kelime.setOnClickListener {
           // dialog_fragment().show(supportFragmentManager,"dsad")


            var mProgressDialog=ProgressDialog(this)
            mProgressDialog.setMessage("Downloading file..")
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)

            mProgressDialog.show()

            for (i in 0..70){

                mProgressDialog.progress=i
            }
        }




        cardmusic.setOnClickListener {
            var intent=Intent(this,activitymusic::class.java)
            this.startActivity(intent)
            progressmusic.visibility=View.VISIBLE
            iconmusic.visibility=View.INVISIBLE
        }

        Handler().postDelayed({ tarih.setOnClickListener {
            var intent=Intent(this,activity_tarih::class.java)
            this.startActivity(intent)
        }},1000)

        geri.setOnClickListener {
            this.onBackPressed()
        }



    }

    override fun onPause() {
        super.onPause()


    }

    override fun onBackPressed() {
        super.onBackPressed()
        isPaused=true
    }

    override fun onResume() {
        super.onResume()
        progresswall.visibility= View.INVISIBLE
        duvaricon.visibility=View.VISIBLE
        progressmusic.visibility=View.INVISIBLE
        iconmusic.visibility=View.VISIBLE
    }





    inner class alert_dialog(var context: Context){
       val builder=AlertDialog.Builder(context)
        val dialogView=layoutInflater.inflate(R.layout.progress,null)
        var mesaj=dialogView.findViewById<TextView>(R.id.textMesaj)
        var progress=dialogView.progressBar
         var dialog: AlertDialog? =null
        fun dialogShow() {

            Handler().postDelayed({ mesaj.text="Resimler hazırlanıyor... " +
                    "Lütfen bekleyin..."
                builder.setView(dialogView)
                builder.setCancelable(false)
                dialog=builder.create()
                dialog?.show()
                if (isPaused==true){
                    dialog?.dismiss()
                }},3000)



            Handler().postDelayed({dialog?.dismiss()},3000)


        }




    }



}
