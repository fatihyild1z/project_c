package com.yildizsoft.fatih.br


import android.content.Context

import android.graphics.Bitmap
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.support.v7.widget.RecyclerView
import android.util.Log

import com.yildizsoft.fatih.br.fragment.MusicFragment
import com.yildizsoft.fatih.br.fragment.HomeFragment
import com.yildizsoft.fatih.br.fragment.imageFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar_main.*
import kotlinx.android.synthetic.main.fragment_image.*


class MainActivity : AppCompatActivity() {

        var pagerAdapter:PageAdapter?=null
    var helper=DatabaseHelper(this)
    var resimler=ArrayList<Bitmap>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)
        var img=image_recyclerView as RecyclerView?

        var bg=backgroundTask(resimler,this)
        bg.execute()



        pagerAdapter= PageAdapter(supportFragmentManager,resimler)
        pagerAdapter!!.fragmentEkle(HomeFragment(),"Home")
        pagerAdapter!!.fragmentEkle(MusicFragment(),"Music")
        pagerAdapter!!.fragmentEkle(imageFragment(),"İmage")



        viewPager.adapter=pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayoutIcon()
}



    fun tabLayoutIcon(){
        tabLayout.getTabAt(0)?.setIcon(R.drawable.homep)
        tabLayout.getTabAt(0)?.setText("Anasayfa")
        tabLayout.getTabAt(1)?.setIcon(R.drawable.headp)
        tabLayout.getTabAt(1)?.setText("Müzik")
        tabLayout.getTabAt(2)?.setIcon(R.drawable.wall)
        tabLayout.getTabAt(2)?.setText("Duvar Kağıdı")

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
        var fragment=imageFragment()



        override fun doInBackground(vararg params: Void?): Int? {

            if (bitmap1!=null && bitmap2!= null && bitmap3!= null && bitmap4!= null && bitmap5!= null
                    && bitmap6!= null && bitmap7!= null && bitmap8!= null) {
                Log.e("arkaplan","mainactivity")
                resimler.add(bitmap1)
                resimler.add(bitmap2)
                resimler.add(bitmap3)
                resimler.add(bitmap4)
                resimler.add(bitmap5)
                resimler.add(bitmap6)
                resimler.add(bitmap7)
                resimler.add(bitmap8)


                Log.e("resimlerin eleman sayii",resimler.size.toString())


            }




            return null
        }




    }






}
