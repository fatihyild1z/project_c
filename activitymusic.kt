package com.yildizsoft.fatih.br

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.*
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.ActivityCompat
import android.support.v7.widget.LinearLayoutManager
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.activity_tarih.*
import kotlinx.android.synthetic.main.activitymusic.*
import kotlinx.android.synthetic.main.dialog_fragment.*
import kotlinx.android.synthetic.main.indiriliyor.view.*
import java.io.*
import java.net.HttpURLConnection
import java.net.InetAddress
import java.net.URL
import java.net.UnknownHostException
import java.text.DecimalFormat

class activitymusic : AppCompatActivity() {
    var sayi=0
    var sayi1=0
    var isimler=ArrayList<String>()
    var path=ArrayList<String>()
    var bytes=ArrayList<Int>()
    var boolean=false
    var internetDurum=false
    var activityKontrol=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymusic)
        val permissions = arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        ActivityCompat.requestPermissions(this, permissions,1)
        activityKontrol=0
      /*  var kon1=kontrol("circassian.mp3")
        var kon2=kontrol("circassian1.mp3")
        var kon3=kontrol("circassian2.mp3")
        var kon4=kontrol("circassian3.mp3") */

       // if (kon1 /* && kon2 && kon3 && kon4) */){}
        adapterVerileri()

        if (netKontrol()){
            internetDurum=true
        }


        var adapter=MusicAdapter(isimler,this,path,activityKontrol)
        recyclerViewMusic.layoutManager=LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        recyclerViewMusic.adapter=adapter


        geri2.setOnClickListener { onBackPressed() }

        Toast.makeText(this,freeMemory()+":::::",Toast.LENGTH_LONG).show()
        var ad=false
        isNetwork(ad,this).execute()











/*
button3.setOnClickListener {
            var storage= FirebaseStorage.getInstance()

            var referans=storage.getReferenceFromUrl("gs://may-d10ff.appspot.com")
            var musicRef=referans.child("musics/circassian.mp3")




            indir(musicRef).execute()








            /*
            var localfile=File.createTempFile("musics","mp3")
              musicRef.getFile(localfile).addOnSuccessListener {
                var mediaPlayer=MediaPlayer.create(this,Uri.parse(localfile.path))
                try {
                    mediaPlayer.isLooping=true
                    mediaPlayer.prepare()

                }catch (Ex:IllegalStateException){
                    Log.e("ds",Ex.toString())
                }
                catch (ex:IOException){
                    Log.e("ds",ex.toString())
                }

                mediaPlayer.start()

            }
             */



            /*
            var long:Long=6173435
            musicRef.getBytes(long).addOnSuccessListener {
              try {
                  path.mkdir()
                  var fileOutputStream=FileOutputStream(path)
                  fileOutputStream.write(it)
                  fileOutputStream.close()
                  Log.e("tamamdır",path.path)
              }catch (ex:Exception){
                  Log.e("ww",ex.toString())
              }
            }

             */




        }
 */




    }

    override fun onStart() {
        super.onStart()


    }
    fun freeMemory():String{
        val statFs = StatFs(Environment.getRootDirectory().absolutePath)
        val Free = (statFs.availableBlocks * statFs.blockSize.toLong())
        val s=bytesToHuman(Free)
        return s
    }

    fun floatForm(d: Double): String {
        return DecimalFormat("#.##").format(d)
    }


    fun bytesToHuman(size: Long): String {
        val Kb = (1 * 1024).toLong()
        val Mb = Kb * 1024
        val Gb = Mb * 1024
        val Tb = Gb * 1024
        val Pb = Tb * 1024
        val Eb = Pb * 1024

        if (size < Kb) return floatForm(size.toDouble()) + " byte"
        if (size >= Kb && size < Mb) return floatForm(size.toDouble() / Kb) + " Kb"
        if (size >= Mb && size < Gb) return floatForm(size.toDouble() / Mb) + " Mb"
        if (size >= Gb && size < Tb) return floatForm(size.toDouble() / Gb) + " Gb"
        if (size >= Tb && size < Pb) return floatForm(size.toDouble() / Tb) + " Tb"
        if (size >= Pb && size < Eb) return floatForm(size.toDouble() / Pb) + " Pb"
        return if (size >= Eb) floatForm(size.toDouble() / Eb) + " Eb" else "???"

    }
    fun adapterVerileri(){
        isimler.add("Hatav")
        isimler.add("Seriday")
        isimler.add("Anonim Çerkes Ezgileri-1")
        isimler.add("Zexuakue Kix")
        isimler.add("Gupse Kafe")
        isimler.add("Hatti Kafe")
        isimler.add("Pasarey Kafe")
        isimler.add("Yi Pshinal'e")
        isimler.add("The Nobles Kafe")
        isimler.add("Afsati Psi Kafe")





        path.add("circassian4.mp3")
        path.add("circassian5.mp3")
        path.add("circassian6.mp3")
        path.add("circassian10.mp3")
        path.add("circassian11.mp3")
        path.add("circassian13.mp3")
        path.add("circassian14.mp3")
        path.add("circassian17.mp3")
        path.add("circassian18.mp3")
        path.add("circassian20.mp3")



    }

    override fun onStop() {
        super.onStop()
        activityKontrol=1
        Log.e(activityKontrol.toString(),"activiy")
    }


    inner class downloadDialog(var context: Context){

        val builder= AlertDialog.Builder(context)
        val dialogView=layoutInflater.inflate(R.layout.progress,null)
        val dialogViewDownload=layoutInflater.inflate(R.layout.indiriliyor,null)
        var indirmeMesajı=dialogViewDownload.findViewById<TextView>(R.id.indiriliyorText1)
        var progres=dialogViewDownload.progressBar2


        var mesaj=dialogView.findViewById<TextView>(R.id.textMesaj)
        var dialog: AlertDialog? =null

        fun downloadDialog(){
            mesaj.text="Hafızada hiç muzik yok! İndirelim mi?"
            builder.setView(dialogView)
            builder.setCancelable(false)
            builder.setPositiveButton("Evet",{ dialog: DialogInterface?, which: Int ->





            })
            builder.setNegativeButton("Hayır",{ dialog: DialogInterface?, which: Int ->

                finish()


            })
            dialog=builder.create()
            dialog?.show()
            if (isimler.size>0){
                dialog?.dismiss()
            }




        }
        fun downloading(){
            indirmeMesajı.text="Müzikler indiriliyor.Lütfen bekleyiniz...İndirme süresi internet hızınıza göre değişiklik gösterebilir! "
            progres.max=100
            progres.progress=0
            builder.setView(dialogViewDownload)
            builder.setCancelable(false)
            dialog=builder.create()
            dialog?.show()




            /*

             */



        }


    }





   inner class isNetwork(var isAvaible:Boolean,var context: Context):AsyncTask<Void,Void,Boolean>(){
        override fun doInBackground(vararg params: Void?): Boolean {

            isAvaible=haveNetworkConnection()


            return isAvaible
        }


       fun haveNetworkConnection():Boolean{
           var haveConnectedWifi = false
           var haveConnectedMobile = false
           val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

           var netInfo=cm.allNetworkInfo
            for (ni:NetworkInfo in netInfo){
                if (ni.typeName.equals("WIFI")){
                    if (ni.isConnected){
                        haveConnectedWifi = true
                    }
                }
                if (ni.typeName.equals("MOBILE")){
                    if (ni.isConnected){
                        haveConnectedMobile = true
                    }
                }
            }


           return haveConnectedWifi || haveConnectedMobile
       }




       override fun onPostExecute(result: Boolean) {
           super.onPostExecute(result)
           if (result){
               Toast.makeText(context,"internet bağlantısı var",Toast.LENGTH_LONG).show()}

           else{
               Toast.makeText(context,"internet bağlantısı yok",Toast.LENGTH_LONG).show()
           }

       }
    }



    inner class indir(var isim: String,var context: Context,var byte:Int,var title:String):AsyncTask<Void,Int,Int>(){
        val pDialog = ProgressDialog(context) //Your Activity.this

        var byteArraySize=0


        override fun doInBackground(vararg params: Void?): Int {
            var storage= FirebaseStorage.getInstance()
            // fonksiyon bytearrayin sizeını döndürsün onu publishproress ile gönder
            var referans=storage.getReferenceFromUrl("gs://may-d10ff.appspot.com")


            var long:Long=6173435


                try {
                    referans.child("musics/"+isim).getBytes(long).addOnSuccessListener {

                        yaz(it,isim,"Circassian Flag Day Song")
                        bytes.add(it.size)

                        if (kontrol(isim,it.size)){


                        }


                        // şu an indirip dosyaya yazdık oradan da mediaplayerla çaldık
                        // yarın da ilk tıklamayla indirip daha sonra dosyadan okuyarak çalarız


                    byteArraySize=it.size

                    }
                }catch (ex:Exception){}



            /* referans.child("musics/circassian1.mp3").getBytes(long).addOnSuccessListener {

                m2=yaz(it,"circassian1.mp3","Ağlatan Qafe")


                Log.e("tamamdır","helal")
                // şu an indirip dosyaya yazdık oradan da mediaplayerla çaldık
                // yarın da ilk tıklamayla indirip daha sonra dosyadan okuyarak çalarız

            }
            referans.child("musics/circassian2.mp3").getBytes(long).addOnSuccessListener {

                m3=yaz(it,"circassian2.mp3","Free Circassia")


                Log.e("tamamdır","helal")
                // şu an indirip dosyaya yazdık oradan da mediaplayerla çaldık
                // yarın da ilk tıklamayla indirip daha sonra dosyadan okuyarak çalarız

            }
            referans.child("musics/circassian3.mp3").getBytes(long).addOnSuccessListener {

                m4=yaz(it,"circassian3.mp3","Adige nyse")

                Log.e("tamamdır","helal")
                // şu an indirip dosyaya yazdık oradan da mediaplayerla çaldık
                // yarın da ilk tıklamayla indirip daha sonra dosyadan okuyarak çalarız

            } */

            sayi1=1


            return byteArraySize
        }

        override fun onPostExecute(result: Int) {
            super.onPostExecute(result)

            Log.e("byte",isim+byte)

            Handler().postDelayed({
                try {
                    if (kontrol(isim,byte)){



                        pDialog.setMessage(title+" adlı dosya indirmesi tamamlandı")

                        Handler().postDelayed({pDialog.dismiss()},2000)
                    }
                }catch (ex:Exception){
                    Log.e("EXEP",ex.toString())
                }
            },4000)









        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)

        }

        override fun onPreExecute() {

            super.onPreExecute()

            pDialog.setMessage(title+" adlı dosya indiriliyor...")
            Log.e("BoyutİİLK+$isim",byte.toString())

            pDialog.show()

        }





    }

    fun netKontrol():Boolean{
        var connManager=getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var aktifNetBilgisi=connManager.activeNetworkInfo
        return aktifNetBilgisi != null && aktifNetBilgisi.isConnected
    }

    fun yaz(byteArray: ByteArray,child:String,isim:String) {
        //var bitmap=BitmapFactory.decodeResource(resources,R.drawable.history)
        var path=Environment.getExternalStorageDirectory()



        try {
            var dir=File(path,"/save/")
            if(!dir.exists()){
                dir.mkdirs()
            }

            var file=File(dir,child)

            var outputStream: OutputStream? =null
            outputStream=FileOutputStream(file)
           outputStream.write(byteArray)



            outputStream.flush()
            outputStream.close()







        }catch (e:IOException){
            Log.e("hata:",e.toString())
        }catch (ex:FileNotFoundException){
            Log.e("hata2:",ex.toString())
        }




    }
    fun kontrol(child: String,byteArray: Int): Boolean {
        var path=Environment.getExternalStorageDirectory()



        try {
            var dir=File(path,"/save/")
            if(!dir.exists()){
                dir.mkdirs()

            }

            var file=File(dir,child)
            var size=file.readBytes().size

           if (file.exists() || size==byteArray){
                Log.e("Boyut+$size",byteArray.toString())

              return true
           }

        }catch (e:IOException){
            Log.e("hata:",e.toString())
        }catch (ex:FileNotFoundException){
            Log.e("hata2:",ex.toString())
        }

    return false
    }
    fun cal(file:File){
        var mediaPlayer=MediaPlayer.create(this,Uri.parse(file.path))
        try {
            mediaPlayer.isLooping=true
            mediaPlayer.prepare()

        }catch (Ex:IllegalStateException){
            Log.e("ds",Ex.toString())
        }
        catch (ex:IOException){
            Log.e("ds",ex.toString())
        }

        mediaPlayer.start()
    }
}

