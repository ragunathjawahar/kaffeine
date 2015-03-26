package com.mobsandgeeks.shorthand

import android.widget.Toast
import android.content.Context
import android.view.View


public fun Context.showShortToast(messageResId: Int) {
    shortToast(messageResId).show()
}

public fun Context.showLongToast(messageResId: Int) {
    longToast(messageResId).show()
}

public fun Context.showShortToast(message: String) {
    shortToast(message).show()
}

public fun Context.showLongToast(message: String) {
    longToast(message).show()
}

public fun Context.showShortToast(view: View) {
    shortToast(view).show()
}

public fun Context.showLongToast(view: View) {
    longToast(view).show()
}

public fun Context.shortToast(messageResId: Int): Toast {
    return shortToast(getString(messageResId))
}

public fun Context.longToast(messageResId: Int): Toast {
    return longToast(getString(messageResId))
}

public fun Context.shortToast(message: String?): Toast {
    return createToast(this, message, Toast.LENGTH_SHORT)
}

public fun Context.longToast(message: String?): Toast {
    return createToast(this, message, Toast.LENGTH_LONG)
}

public fun Context.shortToast(view: View): Toast {
    return createToast(this, view, Toast.LENGTH_SHORT)
}

public fun Context.longToast(view: View): Toast {
    return createToast(this, view, Toast.LENGTH_LONG)
}

/*
 * -----------------------------------------------------------------------------
 *  Private functions
 * -----------------------------------------------------------------------------
 */
private fun createToast(context: Context, message: String?, length: Int): Toast {
    return Toast.makeText(context, message, length)
}

private fun createToast(context: Context, view: View, length: Int): Toast {
    val toast = Toast(context)
    toast.setView(view)
    toast.setDuration(length)
    return toast
}
