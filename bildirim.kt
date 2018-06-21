package com.yildizsoft.fatih.br


import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.bildirim.view.*
import kotlinx.android.synthetic.main.fragment_bildirim.*
import kotlinx.android.synthetic.main.fragment_bildirim.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class bildirim : DialogFragment() {
    lateinit var layoutid:LinearLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var v=inflater.inflate(R.layout.fragment_bildirim, container, false)
        layoutid=v.findViewById(R.id.bildirimalani)
        var inflater=layoutInflater.inflate(R.layout.bildirim,null)


        layoutid.addView(inflater)
        var inflater2=layoutInflater.inflate(R.layout.bildirim,null)
        inflater2.txt.text="2 yeni bildirim"
        layoutid.addView(inflater2)

        // Inflate the layout for this fragment
        return  v
    }


}
