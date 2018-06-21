package com.yildizsoft.fatih.br

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_wallpaper.*
import kotlinx.android.synthetic.main.indiriliyor.view.*

class activity_wallpaper : AppCompatActivity() {
    var resimler=ArrayList<Bitmap>()
    var kontrol=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpaper)
        var bg=backgroundTask(resimler,this)
        bg.execute()
        Log.e("resimler",resimler.size.toString())







        var adapter=recyclerViewAdapter(this,resimler)
        recDeneme.layoutManager= GridLayoutManager(this,2) as RecyclerView.LayoutManager?
        recDeneme.adapter=adapter






    }

    override fun onBackPressed() {
        super.onBackPressed()

    }

    override fun onStart() {
        super.onStart()
        Log.e("resimlersize",resimler.size.toString())
        if (resimler.size>0){

        }
        //alertdialog kullanarak indirme butonu yap
        else
        {   downloadDialog(this).downloadDialog()


        }
    }

    inner class downloadDialog(var context: Context){

        val builder= AlertDialog.Builder(context)
        val dialogView=layoutInflater.inflate(R.layout.progress,null)
        val dialogViewDownload=layoutInflater.inflate(R.layout.indiriliyor,null)
        var indirmeMesajı=dialogViewDownload.findViewById<TextView>(R.id.indiriliyorText1)

        var mesaj=dialogView.findViewById<TextView>(R.id.textMesaj)

        fun downloadDialog(){
            mesaj.text="Hafızada hiç resim yok! İndirelim mi?"
            builder.setView(dialogView)
            builder.setCancelable(false)
            builder.setPositiveButton("Evet",{ dialog: DialogInterface?, which: Int ->

                downloadTask(context).execute()



            })
            builder.setNegativeButton("Hayır",{ dialog: DialogInterface?, which: Int ->

                finish()


            })
            val dialog=builder.create()
            dialog.show()
            if (resimler.size>0){
                dialog.dismiss()
            }




        }
        fun downloading(){
            indirmeMesajı.text="Resimler indiriliyor.Lütfen bekleyiniz...İndirme süresi internet hızınıza göre değişiklik gösterebilir! "

            builder.setView(dialogViewDownload)
            builder.setCancelable(false)
            val dialog=builder.create()
            dialog.show()

            Handler().postDelayed({dialog.dismiss()
                finish()
            },9000)

        }

    }









    inner class backgroundTask(var resimler:ArrayList<Bitmap>, var context: Context): AsyncTask<Void, Int, Int>(){
        val bitmap1 = ImageSaver(context!!).setFileName("circ1.jpg").setDirectoryName("image1").load()

        val bitmap2 = ImageSaver(context!!).setFileName("circ2.jpg").setDirectoryName("image1").load()
        val bitmap3 = ImageSaver(context!!).setFileName("circ3.jpg").setDirectoryName("image1").load()

        val bitmap4 = ImageSaver(context!!).setFileName("circ4.jpg").setDirectoryName("image1").load()
        val bitmap5 = ImageSaver(context!!).setFileName("circ5.jpg").setDirectoryName("image1").load()
        val bitmap6 = ImageSaver(context!!).setFileName("circ6.jpg").setDirectoryName("image1").load()
        val bitmap7 = ImageSaver(context!!).setFileName("circ7.jpg").setDirectoryName("image1").load()
        val bitmap8 = ImageSaver(context!!).setFileName("circ8.jpg").setDirectoryName("image1").load()
        val bitmap9 = ImageSaver(context!!).setFileName("circ9.jpg").setDirectoryName("image1").load()
        val bitmap10 = ImageSaver(context!!).setFileName("circ10.jpg").setDirectoryName("image1").load()
        val bitmap11 = ImageSaver(context!!).setFileName("circ11.jpg").setDirectoryName("image1").load()
        val bitmap12 = ImageSaver(context!!).setFileName("circ12.jpg").setDirectoryName("image1").load()
        val bitmap13 = ImageSaver(context!!).setFileName("circ13.jpg").setDirectoryName("image1").load()
        val bitmap14 = ImageSaver(context!!).setFileName("circ14.jpg").setDirectoryName("image1").load()
        val bitmap15 = ImageSaver(context!!).setFileName("circ15.jpg").setDirectoryName("image1").load()
        val bitmap16 = ImageSaver(context!!).setFileName("circ16.jpg").setDirectoryName("image1").load()
        val bitmap17 = ImageSaver(context!!).setFileName("circ17.jpg").setDirectoryName("image1").load()
        val bitmap18 = ImageSaver(context!!).setFileName("circ18.jpg").setDirectoryName("image1").load()
        val bitmap19 = ImageSaver(context!!).setFileName("circ19.jpg").setDirectoryName("image1").load()
        val bitmap20 = ImageSaver(context!!).setFileName("circ20.jpg").setDirectoryName("image1").load()
        val bitmaps= arrayOf(bitmap1,bitmap2,bitmap3,bitmap4,bitmap5,bitmap6,bitmap7,bitmap8,bitmap9,
                bitmap10,bitmap11,bitmap12,bitmap13,bitmap14,bitmap15,bitmap16,bitmap17,bitmap18,bitmap19,bitmap20)




        override fun doInBackground(vararg params: Void?): Int? {

            if (bitmap1!=null && bitmap2!= null && bitmap3!= null && bitmap4!= null && bitmap5!= null
                    && bitmap6!= null && bitmap7!= null && bitmap8!= null && bitmap9!= null && bitmap10!= null
                    && bitmap11!= null && bitmap12!= null && bitmap13!= null && bitmap14!= null && bitmap15!= null && bitmap16!= null
                    && bitmap17!= null && bitmap18!= null && bitmap19!= null && bitmap20!= null) {
                Log.e("arkaplan","mainactivity")

                resimler.add(bitmap1)
                resimler.add(bitmap2)
                resimler.add(bitmap3)
                resimler.add(bitmap4)
                resimler.add(bitmap5)
                resimler.add(bitmap6)
                resimler.add(bitmap7)
                resimler.add(bitmap8)
                resimler.add(bitmap9)
                resimler.add(bitmap10)
                resimler.add(bitmap11)
                resimler.add(bitmap12)
                resimler.add(bitmap13)
                resimler.add(bitmap14)
                resimler.add(bitmap15)
                resimler.add(bitmap16)
                resimler.add(bitmap17)
                resimler.add(bitmap18)
                resimler.add(bitmap19)
                resimler.add(bitmap20)


                Log.e("resimlerin eleman sayii",resimler.size.toString())


            }




            return null
        }




    }

    inner class downloadTask(var context: Context):AsyncTask<Void,Int,Boolean>(){

        override fun doInBackground(vararg params: Void?): Boolean {

            lateinit var bm: Bitmap

            var storage= FirebaseStorage.getInstance()

            var referans=storage.getReferenceFromUrl("gs://may-d10ff.appspot.com")
            var mb:Long=493*768
            referans.child("images/circ8.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)


                ImageSaver(context!!).setFileName("circ1.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circ2.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ2.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circ11.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ3.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circ0.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ4.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circ1.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ5.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circ6.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ6.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circ7.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ7.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circ4.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ8.jpg").setDirectoryName("image1").save(bm)

            }



            referans.child("images/circ3.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ9.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circ5.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ10.jpg").setDirectoryName("image1").save(bm)

            }

            referans.child("images/circ9.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ11.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circ10.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ12.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circ12.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ13.jpg").setDirectoryName("image1").save(bm)

            }

            referans.child("images/circlast0.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ14.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circlast1.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ15.jpg").setDirectoryName("image1").save(bm)

            }

            referans.child("images/circlast2.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ16.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circlast3.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ17.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circlast4.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ18.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circlast5.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ19.jpg").setDirectoryName("image1").save(bm)

            }
            referans.child("images/circlast6.jpg").getBytes(mb).addOnSuccessListener {

                bm=bytToBitmap(it)

                ImageSaver(context!!).setFileName("circ20.jpg").setDirectoryName("image1").save(bm)

            }
            kontrol=true

            return kontrol
        }
        fun bytToBitmap(array: ByteArray): Bitmap {//veritabanindan gelen byteArrayi Bitmapa donusturuyor
            var bitmap= BitmapFactory.decodeByteArray(array,0,array.size)
            return bitmap
        }

        override fun onPostExecute(result: Boolean?) {
            super.onPostExecute(result)
            if (result==true){
                downloadDialog(context).downloading()

                Handler().postDelayed({Toast.makeText(context,"İndirme başarılı", Toast.LENGTH_LONG).show()
                    },11000)


            }
            else{
                Toast.makeText(context,"başarısız", Toast.LENGTH_LONG).show()
            }
        }



    }



}






