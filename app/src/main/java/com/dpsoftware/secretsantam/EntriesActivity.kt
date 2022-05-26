package com.dpsoftware.secretsantam

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_entries.*

class EntriesActivity : AppCompatActivity() {

    private var num: Int? = null
    private var calcCount: Int = 0
    private var players: ArrayList<Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_entries)

        Toast.makeText(this,
            R.string.you_can_enter_names,
            Toast.LENGTH_LONG)
            .show()

        val intent: Intent = intent
        num = intent.getIntExtra("num", 3)

        players = ArrayList(3)

        val editTexts = ArrayList<EditText>(num!!)
        for (i in 0 until num!!) {
            val editText = EditText(this)
            editText.hint = resources.getString(R.string.player_entry) + (i + 1).toString()
            editText.inputType = android.text.InputType.TYPE_CLASS_TEXT
            editTexts.add(editText)
        }
        val adapter = EnterNamesAdapter(editTexts)
        enterNamesList.adapter = adapter

        calcBtn.setOnClickListener {
            if (!calculate()) {
                Toast.makeText(this,
                    R.string.calculation_unsuccessful,
                    Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(this,
                    R.string.calculation_completed,
                    Toast.LENGTH_LONG)
                    .show()
                val namesIntent = Intent(this, NamesActivity::class.java).apply {}
                val playerNames: ArrayList<String> = ArrayList(3)
                for (i in 0 until num!!) {
                    var name = editTexts[i].text.toString()
                    if (name == "")
                        name = resources.getString(R.string.player_entry) + (i + 1)
                    playerNames.add(name)
                }
                namesIntent.putStringArrayListExtra("names", playerNames)
                namesIntent.putExtra("players", players)
                startActivity(namesIntent)
            }
        }
    }

    private fun calculate(): Boolean {
        if (++calcCount == 65535)
            return false

        if (players!!.isNotEmpty())
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
