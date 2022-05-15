package com.dpsoftware.secretsantam

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import java.util.ArrayList

class NamesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_names)

        val intent: Intent = intent
        val names: ArrayList<String>? = intent.getStringArrayListExtra("names")

        val namesList: ListView = findViewById(R.id.namesList)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names!!)
        namesList.adapter = adapter
    }
}
