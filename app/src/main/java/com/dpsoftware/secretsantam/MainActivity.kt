package com.dpsoftware.secretsantam

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_main)

        val spinnerArray: ArrayList<String> = ArrayList(3)
        for (i in 3..99)
            spinnerArray.add(i.toString())
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, spinnerArray)
        spinner.adapter = arrayAdapter

        enterNamesBtn.setOnClickListener {
            val num: Int = spinner.selectedItem.toString().toInt()
            enterNames(num)
        }
    }

    private fun enterNames(num: Int) {
        val entriesIntent = Intent(this, EntriesActivity::class.java).apply {}
        entriesIntent.putExtra("num", num)
        startActivity(entriesIntent)
    }
}
