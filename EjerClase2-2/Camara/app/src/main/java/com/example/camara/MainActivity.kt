package com.example.camara

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    internal lateinit var clmg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cBtn = findViewById<Button>(R.id.button) as Button

        clmg = findViewById<ImageView>(R.id.clmage)

        cBtn.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,CAMARA_REQUEST)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CAMARA_REQUEST && resultCode == Activity.RESULT_OK)
        {
            val cPhoto = data!!.extras?.get("data") as Bitmap
            clmg.setImageBitmap(cPhoto)
        }
    }

    companion object{
        private val CAMARA_REQUEST = 123
    }
}
