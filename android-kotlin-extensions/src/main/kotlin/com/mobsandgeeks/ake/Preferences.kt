package com.mobsandgeeks.ake

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.os.Build


public fun Context.getDefaultSharedPreferences(): SharedPreferences {
    return PreferenceManager.getDefaultSharedPreferences(this)
}

public fun SharedPreferences.clear() {
    apply(getEditor(this).clear())
}

public fun SharedPreferences.putBoolean(key: String, value: Boolean) {
    apply(getEditor(this).putBoolean(key, value))
}

public fun SharedPreferences.putFloat(key: String, value: Float) {
    apply(getEditor(this).putFloat(key, value))
}

public fun SharedPreferences.putInt(key: String, value: Int) {
    apply(getEditor(this).putInt(key, value))
}

public fun SharedPreferences.putLong(key: String, value: Long) {
    apply(getEditor(this).putLong(key, value))
}

public fun SharedPreferences.putString(key: String, value: String?) {
    apply(getEditor(this).putString(key, value))
}

public fun SharedPreferences.putStringSet(key: String, values: Set<String>?) {
    apply(getEditor(this).putStringSet(key, values))
}

public fun SharedPreferences.remove(key: String) {
    apply(getEditor(this).remove(key))
}

public fun SharedPreferences.bulk(): SharedPreferences {
    this.bulkEditor = this.edit()
    return this
}

public fun SharedPreferences.applyBulk(): SharedPreferences {
    this.bulkEditor?.apply()
    return this
}

public fun SharedPreferences.discardBulk(): SharedPreferences {
    this.bulkEditor = null
    return this
}

/*
 * -----------------------------------------------------------------------------
 *  Private fields
 * -----------------------------------------------------------------------------
 */
private var SharedPreferences.bulkEditor: SharedPreferences.Editor?
    get() = this.bulkEditor

    set(editor: SharedPreferences.Editor?) {
        this.bulkEditor = editor
    }

/*
 * -----------------------------------------------------------------------------
 *  Private methods
 * -----------------------------------------------------------------------------
 */
private fun SharedPreferences.getEditor(
        sharedPreferences: SharedPreferences): SharedPreferences.Editor {
    return sharedPreferences.edit()
}

private fun SharedPreferences.apply(editor: SharedPreferences.Editor) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
        editor.commit()
    } else {
        editor.apply()
    }
}
