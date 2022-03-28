package com.example.exp0327

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
//这里使用lateinit是让其在oncreate后再初始化，本来只是在initview里用，但是后来showlife和showstudy都要用所以变下位置
    lateinit var manager:FragmentManager

    companion object{
        val TAG_LIFE="life"
        val TAG_WORK="work"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        manager=supportFragmentManager
        val trans=manager.beginTransaction()

        trans.replace(R.id.right,RightFragment("我的工作"), TAG_LIFE)
        trans.replace(R.id.right,RightFragment("我的学习"), TAG_WORK)


        trans.commit()
    }

    fun showlife() {
         showFragment(TAG_LIFE)
    }
    fun showstudy() {
        showFragment(TAG_WORK)
    }
   fun showFragment(TAG_LIFE: String) {

       val hint=findViewById<TextView>(R.id.hint)
       hint.isInvisible=false

       //val tag = null
       val frag=manager.findFragmentByTag(tag)?:
          if(tag==TAG_LIFE)RightFragment("我的生活")else RightFragment("我的学习")

       val trans=manager.beginTransaction()

       manager.fragments.forEach{
           if(it !=frag&&it !is LeftFragment){
               trans.hide(it)
           }
       }

       if(frag.isAdded){
           trans.show(frag)
       }else{
           trans.add(R.id.right,frag.tag)
       }

        trans.commit()
    }
}

}