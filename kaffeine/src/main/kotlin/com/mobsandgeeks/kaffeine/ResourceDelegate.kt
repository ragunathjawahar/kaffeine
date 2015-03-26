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
import kotlin.properties.ReadOnlyProperty


public fun Context.animation(resId: Int): ReadOnlyProperty<Any, XmlResourceParser> =
        AnimationResDelegate(this, resId)

public fun Context.boolean(resId: Int): ReadOnlyProperty<Any, Boolean> =
        BooleanResDelegate(this, resId)

public fun Context.color(resId: Int): ReadOnlyProperty<Any, Int> =
        ColorResDelegate(this, resId)

public fun Context.colorStateList(resId: Int): ReadOnlyProperty<Any, ColorStateList> =
        ColorStateListResDelegate(this, resId)

public fun Context.dimension(resId: Int): ReadOnlyProperty<Any, Float> =
        DimensionResDelegate(this, resId)

public fun Context.intArray(resId: Int): ReadOnlyProperty<Any, IntArray> =
        IntArrayResDelegate(this, resId)

public fun Context.integer(resId: Int): ReadOnlyProperty<Any, Int> =
        IntegerResDelegate(this, resId)

public fun Context.layout(resId: Int): ReadOnlyProperty<Any, XmlResourceParser> =
        LayoutResDelegate(this, resId)

public fun Context.movie(resId: Int): ReadOnlyProperty<Any, Movie> =
        MovieResDelegate(this, resId)

// TODO Test
public fun Context.quantityString(resId: Int, quantity: Int): ReadOnlyProperty<Any, String> =
        QuantityStringResDelegate(this, resId, quantity)

// TODO Test
public fun Context.quantityString(
        resId: Int, quantity: Int, vararg formatArgs: Any): ReadOnlyProperty<Any, String> =
                QuantityStringResDelegate(this, resId, quantity, formatArgs)

public fun Context.quantityText(resId: Int, quantity: Int): ReadOnlyProperty<Any, CharSequence> =
        QuantityTextResDelegate(this, resId, quantity)

public fun Context.string(resId: Int): ReadOnlyProperty<Any, String> =
        StringResDelegate(this, resId)

public fun Context.stringArray(resId: Int): ReadOnlyProperty<Any, Array<String>> =
        StringArrayResDelegate(this, resId)

public fun Context.typeface(assetPathId: Int): ReadOnlyProperty<Any, Typeface> =
        TypefaceDelegate(this, assetPathId)

public fun Context.typeface(assetPath: String): ReadOnlyProperty<Any, Typeface> =
        TypefaceDelegate(this, assetPath)

/*
 * -----------------------------------------------------------------------------
 *  Delegates
 * -----------------------------------------------------------------------------
 */
private class AnimationResDelegate(context: Context, resId: Int)
        : ResourceDelegate<XmlResourceParser>(context, resId) {

    override fun lazy(): XmlResourceParser = context.getAnimation(resId)
}

private class BooleanResDelegate(context: Context, resId: Int)
        : ResourceDelegate<Boolean>(context, resId) {

    override fun lazy(): Boolean = context.getBoolean(resId)
}

private class ColorResDelegate(context: Context, resId: Int)
        : ResourceDelegate<Int>(context, resId) {

    override fun lazy(): Int = context.getColor(resId)
}

private class ColorStateListResDelegate(context: Context, resId: Int)
        : ResourceDelegate<ColorStateList>(context, resId) {

    override fun lazy(): ColorStateList = context.getColorStateList(resId)
}

private class DimensionResDelegate(context: Context, resId: Int)
        : ResourceDelegate<Float>(context, resId) {

    override fun lazy(): Float = context.getDimension(resId)
}

private class IntArrayResDelegate(context: Context, resId: Int)
        : ResourceDelegate<IntArray>(context, resId) {

    override fun lazy(): IntArray = context.getIntArray(resId)
}

private class IntegerResDelegate(context: Context, resId: Int)
        : ResourceDelegate<Int>(context, resId) {

    override fun lazy(): Int = context.getInteger(resId)
}

private class LayoutResDelegate(context: Context, resId: Int)
        : ResourceDelegate<XmlResourceParser>(context, resId) {

    override fun lazy(): XmlResourceParser = context.getLayout(resId)
}

private class MovieResDelegate(context: Context, resId: Int)
        : ResourceDelegate<Movie>(context, resId) {

    override fun lazy(): Movie = context.getMovie(resId)
}

private class QuantityStringResDelegate(context: Context, resId: Int, private val quantity: Int)
        : ResourceDelegate<String>(context, resId) {
    private var formatArgs: Any? = null

    constructor(context: Context, resId: Int, quantity: Int, formatArgs: Any)
            : this(context, resId, quantity) {
        this.formatArgs = formatArgs
    }

    override fun lazy(): String = if (formatArgs != null) {
        context.getQuantityString(resId, quantity, formatArgs!!)
    } else {
        context.getQuantityString(resId, quantity)
    }
}

private class QuantityTextResDelegate(context: Context, resId: Int, private val quantity: Int)
        : ResourceDelegate<CharSequence>(context, resId) {

    override fun lazy(): CharSequence = context.getQuantityText(resId, quantity)
}

private class StringResDelegate(context: Context, resId: Int)
        : ResourceDelegate<String>(context, resId) {

    override fun lazy(): String = context.getString(resId)
}

private class StringArrayResDelegate(context: Context, resId: Int)
        : ResourceDelegate<Array<String>>(context, resId) {

    override fun lazy(): Array<String> = context.getStringArray(resId)
}

private class TypefaceDelegate(context: Context, private val assetPathId: Int)
        : ResourceDelegate<Typeface>(context, assetPathId) {
    private var assetPath: String? = null

    constructor(context: Context, assetPath: String) : this(context, -1) {
        this.assetPath = assetPath
    }

    override fun lazy(): Typeface = if (assetPath != null) {
        context.typefaceFromAssets(assetPath!!)
    } else {
        context.typefaceFromAssets(assetPathId)
    }
}

private abstract class ResourceDelegate<T>(val context: Context, val resId: Int)
        : ReadOnlyLazyDelegate<T, Any>
