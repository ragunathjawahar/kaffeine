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


public fun Context.showToastShort(messageResId: Int) {
    toastShort(messageResId).show()
}

public fun Context.showToastLong(messageResId: Int) {
    toastLong(messageResId).show()
}

public fun Context.showToastShort(message: String?) {
    toastShort(message).show()
}

public fun Context.showToastLong(message: String?) {
    toastLong(message).show()
}

public fun Context.showToastShort(view: View) {
    toastShort(view).show()
}

public fun Context.showToastLong(view: View) {
    toastLong(view).show()
}

public fun Context.toastShort(messageResId: Int): Toast {
    return toastShort(getString(messageResId))
}

public fun Context.toastLong(messageResId: Int): Toast {
    return toastLong(getString(messageResId))
}

public fun Context.toastShort(message: String?): Toast {
    return createToast(this, message, Toast.LENGTH_SHORT)
}

public fun Context.toastLong(message: String?): Toast {
    return createToast(this, message, Toast.LENGTH_LONG)
}

public fun Context.toastShort(view: View): Toast {
    return createToast(this, view, Toast.LENGTH_SHORT)
}

public fun Context.toastLong(view: View): Toast {
    return createToast(this, view, Toast.LENGTH_LONG)
}

// TODO Gravity

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
