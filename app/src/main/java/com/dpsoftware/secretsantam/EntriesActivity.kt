package com.dpsoftware.secretsantam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class EntriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entries)

        val intent: Intent = intent
        val num: Int = intent.getIntExtra("num", 3)
    }
}
