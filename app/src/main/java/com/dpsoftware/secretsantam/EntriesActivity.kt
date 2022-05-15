package com.dpsoftware.secretsantam

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class EntriesActivity : AppCompatActivity() {

    private var num: Int? = null
    private var calcCount: Int = 0
    private var players: ArrayList<Int>? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_entries)

        val intent: Intent = intent
        num = intent.getIntExtra("num", 3)

        val enterNamesList: ListView = findViewById(R.id.enterNamesList)
        val editTexts = ArrayList<EditText>(num!!)
        for (i in 0 until num!!) {
            val editText = EditText(this)
            editText.hint = "Player " + (i + 1)
            editText.inputType = android.text.InputType.TYPE_CLASS_TEXT
            editTexts.add(editText)
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, editTexts)
        enterNamesList.adapter = adapter

        val calc: Button = findViewById(R.id.calcBtn)
        calc.setOnClickListener {
            if (!calculate()) {
                Toast.makeText(this,
                    "Calculation was unsuccessful, please try again",
                    Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(this,
                    "Calculation completed successfully, you can now get your results!",
                    Toast.LENGTH_LONG)
                    .show()
                val namesIntent = Intent(this, NamesActivity::class.java).apply {}
                //
                startActivity(namesIntent)
            }
        }
    }

    private fun calculate(): Boolean {
        if (++calcCount == 65535)
            return false

        players!!.clear()
        for (i in 0 until num!!)
            players!!.add(i)
        players!!.shuffle()
        for (i in 0 until num!!)
            if (players!![i] == i)
                calculate()
        return true
    }
}
