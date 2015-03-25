package com.mobsandgeeks.shorthand

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.database.Cursor
import android.graphics.drawable.Drawable
import android.view.KeyEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ListAdapter


public fun Context.alertDialog(init: Dialog.() -> Unit): Dialog {
    val dialog = Dialog(this)
    dialog.init()
    return dialog
}

public class Dialog(val context: Context) {
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

    public fun adapter(adapter: ListAdapter, listener: (DialogInterface, Int) -> Unit) {
        builder.setAdapter(adapter, listener)
    }

    public fun cursor(cursor: Cursor, listener: (DialogInterface, Int) -> Unit,
            labelColumn: String) {
        builder.setCursor(cursor, listener, labelColumn)
    }

    public fun items(itemsId: Int, listener: (DialogInterface, Int) -> Unit) {
        builder.setItems(itemsId, listener)
    }

    public fun items(items: Array<CharSequence>, listener: (DialogInterface, Int) -> Unit) {
        builder.setItems(items, listener)
    }

    public fun positiveButton(textId: Int, listener: ((DialogInterface, Int) -> Unit)?) {
        positiveButton(context.getString(textId), listener)
    }

    public fun positiveButton(text: String, listener: ((DialogInterface, Int) -> Unit)?) {
        builder.setPositiveButton(text, listener)
    }

    public fun negativeButton(textId: Int, listener: ((DialogInterface, Int) -> Unit)?) {
        negativeButton(context.getString(textId), listener)
    }

    public fun negativeButton(text: String, listener: ((DialogInterface, Int) -> Unit)?) {
        builder.setNegativeButton(text, listener)
    }

    public fun neutralButton(textId: Int, listener: ((DialogInterface, Int) -> Unit)?) {
        neutralButton(context.getString(textId), listener)
    }

    public fun neutralButton(text: String, listener: ((DialogInterface, Int) -> Unit)?) {
        builder.setNeutralButton(text, listener)
    }

    public fun onCancelListener(listener: ((DialogInterface) -> Unit)?) {
        builder.setOnCancelListener(listener)
    }

    public fun onItemSelected(listener: AdapterView.OnItemSelectedListener) {
        builder.setOnItemSelectedListener(listener)
    }

    public fun onDismissListener(listener: ((DialogInterface) -> Unit)?) {
        builder.setOnDismissListener(listener)
    }

    public fun onKeyListener(listener: (DialogInterface, Int, KeyEvent) -> Boolean) {
        builder.setOnKeyListener(listener)
    }

    public fun show() {
        builder.create().show()
    }
}
