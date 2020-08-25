package com.example.ubicacion

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById< Button>(R.id.button) as Button

        btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("geo:19.1571699,72.9982072"))
            val intentChooser = Intent.createChooser(intent,"Launch Maps");
            startActivity(intentChooser)
        }

    }

}
