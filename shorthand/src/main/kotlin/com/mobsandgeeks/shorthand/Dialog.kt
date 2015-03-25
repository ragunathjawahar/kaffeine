package com.mobsandgeeks.shorthand

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface


public fun Context.dialog(init: Dialog.() -> Unit): Dialog {
    val dialog = Dialog(this)
    dialog.init()
    return dialog
}

class Dialog(val context: Context) {
    private val builder = AlertDialog.Builder(context)

    var title: Any? = null
        set(value) {
            $title = value
            builder.setTitle(getStringFrom(value))
        }

    var message: Any? = null
        set(value) {
            $message = message
            builder.setMessage(getStringFrom(value))
        }

    var cancellable: Boolean = true
        set(value) {
            $cancellable = value
            builder.setCancelable(value)
        }

    public fun positiveButton(text: Any?, listener: ((DialogInterface, Int) -> Unit)?) {
        builder.setPositiveButton(getStringFrom(text), listener)
    }

    public fun negativeButton(text: Any?, listener: ((DialogInterface, Int) -> Unit)?) {
        builder.setNegativeButton(getStringFrom(text), listener)
    }

    public fun neutralButton(text: Any?, listener: ((DialogInterface, Int) -> Unit)?) {
        builder.setNeutralButton(getStringFrom(text), listener)
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

    private fun getStringFrom(someObject: Any?): String? {
        return if (someObject is Int)
            context.getString(someObject) else someObject?.toString()
    }
}
