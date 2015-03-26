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

import android.widget.Toast
import android.content.Context
import android.view.View


public fun Context.showShortToast(messageResId: Int) {
    shortToast(messageResId).show()
}

public fun Context.showLongToast(messageResId: Int) {
    longToast(messageResId).show()
}

public fun Context.showShortToast(message: String?) {
    shortToast(message).show()
}

public fun Context.showLongToast(message: String?) {
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
