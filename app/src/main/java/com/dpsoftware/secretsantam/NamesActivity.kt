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
                "${names[position]}, ${resources.getString(R.string.present)} ${names[players?.get(position)!!]}!",
                Toast.LENGTH_SHORT)
                .show()
        }
    }
}
