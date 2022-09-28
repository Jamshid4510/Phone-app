package com.example.phoneapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import com.example.phoneapp.R

class AddPhoneListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_phone_list)
    }

    fun onClick(view: View) {
        var card = view as CardView
        var intent = Intent(this, AddPhoneActivity::class.java)
        var text : String = ""
        var cardId = card.id

        when(cardId){
            R.id.card_iphone -> {
                text = "iPhone"
            }
            R.id.card_samsung -> {
                text = "Samsung"
            }
            R.id.card_mi -> {
                text = "Mi"
            }
            R.id.card_sony -> {
                text = "Sony"
            }
            R.id.card_huawei -> {
                text = "Huawei"
            }
            R.id.card_artel -> {
                text = "Artel"
            }
            R.id.card_nokia -> {
                text = "Nokia"
            }
            R.id.card_oppo -> {
                text = "Oppo"
            }
        }

        intent.putExtra("info", text)
        startActivity(intent)

    }
}