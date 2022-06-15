/**
 * Copyright 2022 Dimitris Psathas <dimitrisinbox@gmail.com>
 *
 * This file is part of SecretSantaM.
 *
 * SecretSantaM is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License  as  published by  the  Free Software
 * Foundation,  either version 3 of the License,  or (at your option)  any later
 * version.
 *
 * SecretSantaM is distributed in the hope that it will be useful,  but  WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE.  See the  GNU General Public License  for more details.
 *
 * You should have received a copy of the  GNU General Public License along with
 * SecretSantaM. If not, see <http://www.gnu.org/licenses/>.
 */


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
