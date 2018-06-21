package com.yildizsoft.fatih.br

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.yildizsoft.fatih.br.fragment.HomeFragment
import com.yildizsoft.fatih.br.fragment.MusicFragment
import com.yildizsoft.fatih.br.fragment.imageFragment

/**
 * Created by Fatih on 11.04.2018.
 */
class PageAdapter(fm:FragmentManager,var resimler:ArrayList<Bitmap>):FragmentPagerAdapter(fm) {

    var fragment=fm
    var fragmentItem:ArrayList<Fragment> = ArrayList()
    var fragmentBaslik:ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return when (position){

            1-> {
                MusicFragment()
                Thread.sleep(3000)
                MusicFragment()
            }

            2-> {imageFragment()
                var bundle = Bundle()
                bundle.putParcelableArrayList("test",resimler)
                var frag = imageFragment()
                frag.arguments = bundle
                frag



                     }
            else -> {HomeFragment()
            }
        }

    }

    override fun getCount(): Int {
        return fragmentItem.size
    }
    fun fragmentEkle(fItem:Fragment,fTitle:String){

        fragmentItem.add(fItem)
        fragmentBaslik.add(fTitle)

    }
}