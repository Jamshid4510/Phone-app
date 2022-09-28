package com.example.phoneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneapp.ui.AddPhoneListActivity
import com.example.phoneapp.ui.PhonesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        card_add_phone.setOnClickListener {
            val intent = Intent(this, AddPhoneListActivity::class.java)
            startActivity(intent)
        }

        card_menu.setOnClickListener {
            val intent = Intent(this, PhonesActivity::class.java)
            startActivity(intent)
        }

    }
}