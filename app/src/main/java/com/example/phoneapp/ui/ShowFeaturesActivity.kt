package com.example.phoneapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneapp.R
import com.example.phoneapp.models.Phone
import kotlinx.android.synthetic.main.activity_show_features.*

class ShowFeaturesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_features)

        val stringExtra = intent.getSerializableExtra("features") as Phone

        tv_phone_name.text = stringExtra.name
        tv_features.text = stringExtra.features
    }
}