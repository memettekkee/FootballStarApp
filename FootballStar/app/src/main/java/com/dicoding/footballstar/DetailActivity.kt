package com.dicoding.footballstar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val Photoz: ImageView = findViewById(R.id.img_detail)
        val Namez: TextView = findViewById(R.id.nama_pemain)
        val Detailz: TextView = findViewById(R.id.deskripsi)

        Namez.text = intent.getStringExtra("football_name")
        Detailz.text = intent.getStringExtra("football_deskripsi")
        Photoz.setImageResource(intent.getIntExtra("football_img", 0))
    }
}