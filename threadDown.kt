package com.yildizsoft.fatih.br

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import java.io.IOException

class threadDown(var context: Context):Thread(){
    lateinit var bm: Bitmap
    var storage= FirebaseStorage.getInstance()
    override fun run() {
        try {
            firebaseDown()
            Thread.sleep(1000)
            Log.e("threadiçi","islem")



        }catch (ex:IOException){
            ex.printStackTrace()
        }

    }



    fun firebaseDown(){


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


}
    fun bytToBitmap(array: ByteArray): Bitmap {//veritabanindan gelen byteArrayi Bitmapa donusturuyor
        var bitmap= BitmapFactory.decodeByteArray(array,0,array.size)
        return bitmap
    }

}