package com.dpsoftware.secretsantam

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_names.*

class NamesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_names)

        val intent: Intent = intent
        val names: ArrayList<String>? = intent.getStringArrayListExtra("names")
        val players: ArrayList<Int>? = intent.getIntegerArrayListExtra("players")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names!!)
        namesList.adapter = adapter

        namesList.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this,
                "${names[position]}, " + R.string.present + " ${names[players?.get(position)!!]}!",
                Toast.LENGTH_SHORT)
                .show()
        }
    }
}
