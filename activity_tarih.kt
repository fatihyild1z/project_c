package com.yildizsoft.fatih.br

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_tarih.*
import kotlinx.android.synthetic.main.activitymusic.*

class activity_tarih : AppCompatActivity() {
        var resimler=ArrayList<Int>()
        var isimler=ArrayList<String>()
        var yaslar=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarih)
        resimler.add(R.drawable.cerkesethem)

        isimler.add("Çerkes Ethem")
        yaslar.add("(1886-1948)")
        isimler.add("Kazım Karabekir")
        yaslar.add("(1882-1948)")
        resimler.add(R.drawable.kazim)
        var adapter=PersonAdapter(resimler,isimler,yaslar)
        recyclerview_tarih.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        recyclerview_tarih.adapter=adapter
    }
}
