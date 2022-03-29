package com.example.exp0327

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class LeftFragment : Fragment(), View.OnClickListener {

    val TAG="LeftFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_left,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_life).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_study).setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val act=requireActivity() as MainActivity

        if (v != null) {
            when(v.id){
                R.id.btn_life->{
                    act.showlife()
                }
                R.id.btn_study->{
                    act.showstudy()
                }
            }
        }
    }
}


