package com.dpsoftware.secretsantam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

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
                enterNames(text)
        }
    }

    private fun enterNames(num: String) {
        val entriesIntent = Intent(this, EntriesActivity::class.java).apply {}
        entriesIntent.putExtra("num", num)
        startActivity(entriesIntent)
    }
}
