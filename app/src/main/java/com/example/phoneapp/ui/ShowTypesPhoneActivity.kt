package com.example.phoneapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneapp.R
import com.example.phoneapp.adapters.AdapterTypesPhone
import com.example.phoneapp.models.Phone
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_show_types_phone.*
import java.lang.reflect.Type

class ShowTypesPhoneActivity : AppCompatActivity() {
    var myList = arrayListOf<Phone>()
    var list = arrayListOf<Phone>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_types_phone)

        loadData()
        val phoneT = intent.getStringExtra("type")
        initData(phoneT!!)

        tv_phone_type_top.text = phoneT

        list_view.adapter = AdapterTypesPhone(myList)

    }

    private fun initData(t : String){
        for (i in list){
            if (i.types == t){
                myList.add(i)
            }
        }
    }

    private fun loadData(){
        var sharedPreferences = getSharedPreferences("phone app", MODE_PRIVATE)

        var gSon = Gson()
        var jSon = sharedPreferences.getString("phone list", "")

        if (jSon == ""){
            list = arrayListOf()
        } else{
            val type: Type = object : TypeToken<ArrayList<Phone?>?>() {}.type
            list = gSon.fromJson(jSon, type)
        }
    }
}