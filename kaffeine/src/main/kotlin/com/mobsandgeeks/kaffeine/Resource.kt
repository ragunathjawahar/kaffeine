package com.mobsandgeeks.kaffeine

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import android.content.res.XmlResourceParser
import android.content.res.ColorStateList
import android.util.DisplayMetrics
import android.graphics.Movie


public fun Context.getAnimation(animResId: Int): XmlResourceParser =
        resources().getAnimation(animResId)

public fun Context.getBoolean(booleanResId: Int): Boolean =
        resources().getBoolean(booleanResId)

public fun Context.getColor(colorResId: Int): Int =
        resources().getColor(colorResId)

public fun Context.getColorStateList(stateListResId: Int): ColorStateList =
        resources().getColorStateList(stateListResId)

public fun Context.getDimension(dimenResId: Int): Float =
        resources().getDimension(dimenResId)

public fun Context.getIntArray(id: Int): IntArray =
        resources().getIntArray(id)

public fun Context.getDisplayMetrics(): DisplayMetrics =
        resources().getDisplayMetrics()

public fun Context.getInteger(id: Int): Int =
        resources().getInteger(id)

public fun Context.getLayout(id: Int): XmlResourceParser =
        resources().getLayout(id)

public fun Context.getMovie(id: Int): Movie =
        resources().getMovie(id)

public fun Context.getQuantityString(id: Int, quantity: Int, vararg formatArgs: Any): String =
        resources().getQuantityString(id, quantity, formatArgs)

public fun Context.getQuantityString(id: Int, quantity: Int): String =
        resources().getQuantityString(id, quantity)

public fun Context.getQuantityText(id: Int, quantity: Int): CharSequence =
        resources().getQuantityText(id, quantity)

public fun Context.getStringArray(arrayResId: Int): Array<String> =
        resources().getStringArray(arrayResId)

public fun Context.typefaceFromAssets(assetPathResId: Int): Typeface =
        typefaceFromAssets(getString(assetPathResId))

public fun Context.typefaceFromAssets(assetPath: String): Typeface =
        Typeface.createFromAsset(getAssets(), assetPath)

/*
 * -----------------------------------------------------------------------------
 *  Private functions
 * -----------------------------------------------------------------------------
 */
private fun Context.resources(): Resources = this.getResources()
