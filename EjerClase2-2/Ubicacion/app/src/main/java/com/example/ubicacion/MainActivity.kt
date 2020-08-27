package com.example.ubicacion

import android.content.Intent
import android.content.SearchRecentSuggestionsProvider
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var mButtonMap: Button
    lateinit var mEdtSearch: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById< Button>(R.id.button) as Button

        btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("geo:19.1571699,72.9982072"))
            //intent.setData(Uri.parse("geo:34.42907,58.23438"))
            val intentChooser = Intent.createChooser(intent,"Launch Maps");
            startActivity(intentChooser)
        }

        mButtonMap = findViewById(R.id.mapBtn)
        mEdtSearch = findViewById(R.id.locationEdt)

        mButtonMap.setOnClickListener {
            val mUriIntent = Uri.parse("geo:0,0?q=${mEdtSearch.text.toString()}")
            val mMapIntent = Intent(Intent.ACTION_VIEW,mUriIntent)
            mMapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mMapIntent)
        }

    }

}
