package com.dpsoftware.secretsantam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private var numberOfPlayers: EditText? = null
    private var enterNames: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberOfPlayers = findViewById(R.id.numberOfPlayersEdit)
        enterNames = findViewById(R.id.enterNamesBtn)

        enterNames!!.setOnClickListener {
            val text: String = numberOfPlayers!!.text.toString()
            if (text.isNotEmpty())
                enterNames(text.toInt())
        }
    }

    private fun enterNames(num: Int) {
        val intent = Intent(this, EntriesActivity::class.java).apply {

        }
        startActivity(intent)
    }
}
