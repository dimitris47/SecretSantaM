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