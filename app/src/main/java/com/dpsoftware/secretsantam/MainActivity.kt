package com.dpsoftware.secretsantam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get

class MainActivity : AppCompatActivity() {

    private var spinner: Spinner? = null
    private var enterNames: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        val spinnerArray: ArrayList<String> = ArrayList(3)
        for (i in 3..99)
            spinnerArray.add(i.toString())
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, spinnerArray)
        spinner!!.adapter = arrayAdapter
        
        enterNames = findViewById(R.id.enterNamesBtn)

        enterNames!!.setOnClickListener {
            val text: String = spinner!!.toString()
            if (text.isNotEmpty())
                enterNames(text.toInt())
        }
    }

    private fun enterNames(num: Int) {
        val intent = Intent(this, EntriesActivity::class.java).apply {

        }
        intent.putExtra("num", num)
        startActivity(intent)
    }
}
