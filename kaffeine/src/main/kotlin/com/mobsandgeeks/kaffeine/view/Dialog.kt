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

package com.mobsandgeeks.kaffeine.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.database.Cursor
import android.graphics.drawable.Drawable
import android.view.KeyEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ListAdapter


public fun alertDialog(context: Context, init: KaffeineDialog.() -> Unit): Dialog {
    val kaffeineDialog = KaffeineDialog(context)
    kaffeineDialog.init()
    return kaffeineDialog.build()
}

public class KaffeineDialog(val context: Context) {
    private val builder = AlertDialog.Builder(context)

    var titleId: Int = -1
        set(value) {
            $titleId = value
            builder.setTitle($titleId)
        }

    var title: String? = null
        set(value) {
            $title = value
            builder.setTitle($title)
        }

    var messageId: Int = -1
        set(value) {
            $messageId = value
            builder.setMessage($messageId)
        }

    var message: String? = null
        set(value) {
            $message = value
            builder.setMessage($message)
        }

    var cancelable: Boolean = true
        set(value) {
            $cancelable = value
            builder.setCancelable($cancelable)
        }

    var customTitle: View? = null
        set(value) {
            $customTitle = value
            builder.setCustomTitle($customTitle)
        }

    var icon: Drawable? = null
        set(value) {
            $icon = value
            builder.setIcon($icon)
        }

    var iconId: Int = -1
        set(value) {
            $iconId = value
            builder.setIcon($iconId)
        }

    var iconAttribute: Int = -1
        set(value) {
            $iconAttribute = value
            builder.setIconAttribute($iconAttribute)
        }

    var inverseBackgroundForced: Boolean = false
        set(value) {
            $inverseBackgroundForced = value
            builder.setInverseBackgroundForced($inverseBackgroundForced)
        }

    var view: View? = null
        set(value) {
            $view = value
            builder.setView($view)
        }

    var viewId: Int = View.NO_ID
        set(value) {
            $viewId = value
            builder.setView($viewId)
        }

    public fun adapter(adapter: ListAdapter,
            listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setAdapter(adapter, listener)
    }

    public fun cursor(cursor: Cursor, listener: (dialog: DialogInterface, which: Int) -> Unit,
            labelColumn: String) {
        builder.setCursor(cursor, listener, labelColumn)
    }

    public fun items(itemsId: Int, listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setItems(itemsId, listener)
    }

    public fun items(items: Array<CharSequence>,
            listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setItems(items, listener)
    }

    public fun multiChoiceItems(items: Array<CharSequence>, checkedItems: BooleanArray,
            listener: (dialog: DialogInterface, which: Int, isChecked: Boolean) -> Unit) {
        builder.setMultiChoiceItems(items, checkedItems, listener)
    }

    public fun multiChoiceItems(cursor: Cursor, isCheckedColumn: String, labelColumn: String,
            listener: (dialog: DialogInterface, which: Int, isChecked: Boolean) -> Unit) {
        builder.setMultiChoiceItems(cursor, isCheckedColumn, labelColumn, listener)
    }

    public fun multiChoiceItems(itemsId: Int, checkedItems: BooleanArray,
            listener: (dialog: DialogInterface, which: Int, isChecked: Boolean) -> Unit) {
        builder.setMultiChoiceItems(itemsId, checkedItems, listener)
    }

    public fun positiveButton(textId: Int,
            listener: ((dialog: DialogInterface, which: Int) -> Unit)?) {
        positiveButton(context.getString(textId), listener)
    }

    public fun positiveButton(text: String,
            listener: ((dialog: DialogInterface, which: Int) -> Unit)?) {
        builder.setPositiveButton(text, listener)
    }

    public fun singleChoiceItems(items: Array<CharSequence>, checkedItem: Int,
            listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setSingleChoiceItems(items, checkedItem, listener)
    }

    public fun singleChoiceItems(items: ListAdapter, checkedItem: Int,
            listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setSingleChoiceItems(items, checkedItem, listener)
    }

    public fun singleChoiceItems(itemsId: Int, checkedItem: Int,
            listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setSingleChoiceItems(itemsId, checkedItem, listener)
    }

    public fun singleChoiceItems(cursor: Cursor, checkedItem: Int, labelColumn: String,
            listener: (dialog: DialogInterface, which: Int) -> Unit) {
        builder.setSingleChoiceItems(cursor, checkedItem, labelColumn, listener)
    }

    public fun negativeButton(textId: Int,
            listener: ((dialog: DialogInterface, which: Int) -> Unit)?) {
        negativeButton(context.getString(textId), listener)
    }

    public fun negativeButton(text: String,
            listener: ((dialog: DialogInterface, which: Int) -> Unit)?) {
        builder.setNegativeButton(text, listener)
    }

    public fun neutralButton(textId: Int,
            listener: ((dialog: DialogInterface, which: Int) -> Unit)?) {
        neutralButton(context.getString(textId), listener)
    }

    public fun neutralButton(text: String,
            listener: ((dialog: DialogInterface, which: Int) -> Unit)?) {
        builder.setNeutralButton(text, listener)
    }

    public fun onCancelListener(listener: ((dialog: DialogInterface) -> Unit)?) {
        builder.setOnCancelListener(listener)
    }

    public fun onItemSelectedListener(listener: AdapterView.OnItemSelectedListener) {
        builder.setOnItemSelectedListener(listener)
    }

    public fun onDismissListener(listener: ((dialog: DialogInterface) -> Unit)?) {
        builder.setOnDismissListener(listener)
    }

    public fun onKeyListener(
            listener: (dialog: DialogInterface, keyCode: Int, event: KeyEvent) -> Boolean) {
        builder.setOnKeyListener(listener)
    }

    fun build(): Dialog = builder.create()
}
