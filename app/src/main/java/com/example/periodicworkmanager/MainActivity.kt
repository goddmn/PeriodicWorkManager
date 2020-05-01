package com.example.periodicworkmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initInputListener()
    }

    private fun initInputListener() {
        btn_save.setOnClickListener {
            val args = Bundle()
            args.putString("value", et_input.text.toString())
            val fragment = FetchResultFragment()
            fragment.arguments = args
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_container, fragment).commit()
            btn_save.visibility = View.GONE
        }
    }

}
