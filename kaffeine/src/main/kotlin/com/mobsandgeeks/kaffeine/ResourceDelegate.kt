package com.mobsandgeeks.kaffeine

import android.content.Context
import android.view.animation.Animation
import kotlin.properties.ReadOnlyProperty


public fun Context.string(resId: Int): ReadOnlyProperty<Any, String?> =
        StringResDelegate(this, resId)

public fun Context.stringArray(resId: Int): ReadOnlyProperty<Any, Array<String>?> =
        StringArrayResDelegate(this, resId)


class StringResDelegate(context: Context, resId: Int) : ResourceDelegate<String?>(context, resId) {

    override fun get(thisRef: Any, desc: PropertyMetadata): String? =
            context.getString(resId)
}

private class StringArrayResDelegate(context: Context, resId: Int)
        : ResourceDelegate<Array<String>?>(context, resId) {

    override fun get(thisRef: Any, desc: PropertyMetadata): Array<String>? =
            context.getStringArray(resId)
}

private abstract class ResourceDelegate<T>(val context: Context, val resId: Int)
        : ReadOnlyProperty<Any, T>
