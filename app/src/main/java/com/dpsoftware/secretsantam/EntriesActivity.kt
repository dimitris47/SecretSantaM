package com.dpsoftware.secretsantam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EntriesActivity : AppCompatActivity() {

    var num: Int? = null
    var calcCount: Int = 0
    var players: ArrayList<Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entries)

        val intent: Intent = intent
        num = intent.getIntExtra("num", 3)

        val calc: Button = findViewById(R.id.calcBtn)
        calc.setOnClickListener {
            calculate()

        }
    }

    private fun calculate(): Boolean {
        if (++calcCount == 65535)
            return false

        for (i in 0 until num!!)
            players!!.add(i)
        players!!.shuffle()

        for (i in 0 until num!!)
            if (players!![i] == i)
                calculate()

        return true
    }
}
