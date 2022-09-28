package com.example.phoneapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.phoneapp.R
import com.example.phoneapp.models.Phone
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_add_phone.*
import java.lang.reflect.Type

class AddPhoneActivity : AppCompatActivity() {
    var correct = true
    var list = arrayListOf<Phone>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_phone)

        val phoneType = intent.getStringExtra("info")

        btn_add.setOnClickListener {
            correct = true

            var name = et_phone_name.text.toString()
            var features = et_phone_features.text.toString()

            name = name.trim()
            features = features.trim()

            if (name.isEmpty() || name.isBlank()){
                et_phone_name.setError("Enter data")
                correct = false
            }

            if (features.isEmpty() || features.isBlank()){
                et_phone_features.setError("Enter some data")
                correct = false
            }

            if (correct){
                // ma'lumotni sharedga saqlash kerak
                loadData()
                var phone = Phone(phoneType!!, name, features)
                list.add(phone)
                saveData()
            }
        }
    }

    private fun saveData(){
        var sharedPreferences = getSharedPreferences("phone app", MODE_PRIVATE)
        var editor = sharedPreferences.edit()

        var gSon = Gson()
        var jSon = gSon.toJson(list)

        editor.putString("phone list", jSon)
        editor.apply()

        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()

        et_phone_name.setText("")
        et_phone_features.setText("")
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