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

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText

class EnterNamesAdapter(editTexts: ArrayList<EditText>) : BaseAdapter() {

    private val texts: ArrayList<EditText> = editTexts

    override fun getCount(): Int {
        return texts.size
    }

    override fun getItem(p0: Int): Any {
        return texts[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        return texts[p0]
    }
}
