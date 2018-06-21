package com.yildizsoft.fatih.br

import android.app.WallpaperManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.fragment_wallpaper.*
import java.io.ByteArrayOutputStream

class DetayActivity : AppCompatActivity() {
    var resimler1=ArrayList<Bitmap>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)
        var position=intent.getIntExtra("position",1)

        var bg=backgroundTask(resimler1,this,position )
        bg.execute()
        Log.e("seie",resimler1.size.toString())












    }

    fun bytToBitmap(array: ByteArray): Bitmap {//veritabanindan gelen byteArrayi Bitmapa donusturuyor
        var bitmap= BitmapFactory.decodeByteArray(array,0,array.size)
        return bitmap
    }

    inner class backgroundTask(var resimler:ArrayList<Bitmap>, var context: Context,var position:Int): AsyncTask<Void, Int, Int>(){
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

        fun imageToByte(bitmap: Bitmap):ByteArray{

            //burada R.drawable.t2 yazan yere sen
            // gelen resmi yazacaksin ama once gelen resmi Bitmapa donustur
            var stream= ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG,40,stream)
            var byteArray=stream.toByteArray()
            return byteArray
        }
      //  /data/data/com.yildizsoft.fatih.br/app_image1
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
                for (i in 0..20){
                    if (position==i)
                    {
                        detayimage.setImageBitmap(resimler.get(position))

                        setDuvar.setOnClickListener {

                            var wallpaperManager=WallpaperManager.getInstance(context)
                            wallpaperManager.setBitmap(resimler.get(position))
                        }


                    }
                }



                Log.e("resimlerin eleman sayii",resimler.size.toString())


            }




            return null
        }
    }
}
