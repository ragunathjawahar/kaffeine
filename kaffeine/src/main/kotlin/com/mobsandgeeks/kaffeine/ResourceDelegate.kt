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

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.XmlResourceParser
import android.graphics.Movie
import android.graphics.Typeface
import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty


public fun Context.animation(resId: Int): ReadOnlyProperty<Any, XmlResourceParser> =
        Delegates.lazy { getAnimation(resId) }

public fun Context.boolean(resId: Int): ReadOnlyProperty<Any, Boolean> = Delegates.lazy {
    getBoolean(resId)
}

public fun Context.color(resId: Int): ReadOnlyProperty<Any, Int> = Delegates.lazy {
    getColor(resId)
}

public fun Context.colorStateList(resId: Int): ReadOnlyProperty<Any, ColorStateList> =
        Delegates.lazy { getColorStateList(resId) }

public fun Context.dimension(resId: Int): ReadOnlyProperty<Any, Float> = Delegates.lazy {
    getDimension(resId)
}

public fun Context.intArray(resId: Int): ReadOnlyProperty<Any, IntArray> = Delegates.lazy {
    getIntArray(resId)
}

public fun Context.integer(resId: Int): ReadOnlyProperty<Any, Int> = Delegates.lazy {
    getInteger(resId)
}

public fun Context.layout(resId: Int): ReadOnlyProperty<Any, XmlResourceParser> = Delegates.lazy {
    getLayout(resId)
}

public fun Context.movie(resId: Int): ReadOnlyProperty<Any, Movie> = Delegates.lazy {
    getMovie(resId)
}

// TODO Test
public fun Context.quantityString(resId: Int, quantity: Int): ReadOnlyProperty<Any, String> =
        Delegates.lazy { getQuantityString(resId, quantity) }

// TODO Test
public fun Context.quantityString(
        resId: Int, quantity: Int, vararg formatArgs: Any): ReadOnlyProperty<Any, String> =
                Delegates.lazy { getQuantityString(resId, quantity, formatArgs) }

public fun Context.quantityText(resId: Int, quantity: Int): ReadOnlyProperty<Any, CharSequence> =
        Delegates.lazy { getQuantityText(resId, quantity) }

public fun Context.string(resId: Int): ReadOnlyProperty<Any, String> = Delegates.lazy {
    getString(resId)
}

public fun Context.stringArray(resId: Int): ReadOnlyProperty<Any, Array<String>> = Delegates.lazy {
    getStringArray(resId)
}

public fun Context.typeface(assetPathId: Int): ReadOnlyProperty<Any, Typeface> = Delegates.lazy {
    typefaceFromAssets(assetPathId)
}

public fun Context.typeface(assetPath: String): ReadOnlyProperty<Any, Typeface> = Delegates.lazy {
    typefaceFromAssets(assetPath)
}
