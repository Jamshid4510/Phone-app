package com.example.phoneapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.BaseAdapter
import com.example.phoneapp.R
import com.example.phoneapp.models.Phone
import com.example.phoneapp.ui.ShowFeaturesActivity
import kotlinx.android.synthetic.main.item.view.*

class AdapterTypesPhone(var list: ArrayList<Phone>) : BaseAdapter() {
    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Phone = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView : View

        if (convertView == null){
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)
        } else{
            itemView = convertView
        }

        itemView.tv_phone_name.text = list[position].name

        itemView.card_item.setOnClickListener {
            val intent = Intent(parent?.context, ShowFeaturesActivity::class.java)
            intent.putExtra("features", list[position])
            parent?.context?.startActivity(intent)
        }

        val rotateAnimation = AnimationUtils.loadAnimation(parent?.context, R.anim.scale_animation)
        itemView.startAnimation(rotateAnimation)

        return itemView
    }
}