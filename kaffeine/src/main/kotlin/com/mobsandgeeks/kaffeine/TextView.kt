package com.mobsandgeeks.kaffeine

import android.text.Html
import android.widget.TextView
import java.lang


public fun TextView.getString(): String = getString(false)

public fun TextView.getString(trim: Boolean): String {
    val text = this.getText().toString();
    return if (trim) text.trim() else text
}

public fun TextView.getShort(): Short = lang.Short.parseShort(getString(true))

public fun TextView.getInt(): Int = Integer.parseInt(getString(true))

public fun TextView.getLong(): Long = lang.Long.parseLong(getString(true))

public fun TextView.getFloat(): Float = lang.Float.parseFloat(getString(true))

public fun TextView.getDouble(): Double = lang.Double.parseDouble(getString(true))

public fun TextView.getBoolean(): Boolean =
        lang.Boolean.parseBoolean(getString(true).toLowerCase())

public fun TextView.setHtml(html: String) {
    this.setText(Html.fromHtml(html))
}

public fun TextView.setHtml(htmlResId: Int) {
    val html = this.getContext().getString(htmlResId)
    setHtml(html)
}
