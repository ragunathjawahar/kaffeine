/*
 * Copyright (C) 2015 Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
