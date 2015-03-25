package com.mobsandgeeks.shorthand

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface


public fun Context.dialog(init: Dialog.() -> Unit): Dialog {
    val dialog = Dialog(this)
    dialog.init()
    return dialog
}

public class Dialog(val context: Context) {
    private val builder = AlertDialog.Builder(context)

    var titleResId: Int = -1
        set(value) {
            $titleResId = value
            builder.setTitle($titleResId)
        }

    var title: String? = null
        set(value) {
            $title = value
            builder.setTitle($title)
        }

    var messageResId: Int = -1
        set(value) {
            $messageResId = value
            builder.setMessage($messageResId)
        }

    var message: String? = null
        set(value) {
            $message = value
            builder.setMessage($message)
        }

    var cancellable: Boolean = true
        set(value) {
            $cancellable = value
            builder.setCancelable($cancellable)
        }

    public fun positiveButton(textResId: Int, listener: ((DialogInterface, Int) -> Unit)?) {
        positiveButton(context.getString(textResId), listener)
    }

    public fun positiveButton(text: String, listener: ((DialogInterface, Int) -> Unit)?) {
        builder.setPositiveButton(text, listener)
    }

    public fun negativeButton(textResId: Int, listener: ((DialogInterface, Int) -> Unit)?) {
        negativeButton(context.getString(textResId), listener)
    }

    public fun negativeButton(text: String, listener: ((DialogInterface, Int) -> Unit)?) {
        builder.setNegativeButton(text, listener)
    }

    public fun neutralButton(textResId: Int, listener: ((DialogInterface, Int) -> Unit)?) {
        neutralButton(context.getString(textResId), listener)
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
