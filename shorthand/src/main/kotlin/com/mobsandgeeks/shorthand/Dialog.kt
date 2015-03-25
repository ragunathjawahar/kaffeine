package com.mobsandgeeks.shorthand

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.database.Cursor
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

    public fun adapter(adapter: ListAdapter, listener: (DialogInterface, Int) -> Unit) {
        builder.setAdapter(adapter, listener)
    }

    public fun cursor(cursor: Cursor, listener: (DialogInterface, Int) -> Unit,
            labelColumn: String) {
        builder.setCursor(cursor, listener, labelColumn)
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

    public fun onDismissListener(listener: ((DialogInterface) -> Unit)?) {
        builder.setOnDismissListener(listener)
    }

    public fun onCancelListener(listener: ((DialogInterface) -> Unit)?) {
        builder.setOnCancelListener(listener)
    }

    public fun show() {
        builder.create().show()
    }
}
