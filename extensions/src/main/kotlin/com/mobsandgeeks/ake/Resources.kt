package com.mobsandgeeks.ake

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import android.content.res.XmlResourceParser
import android.content.res.ColorStateList
import android.util.DisplayMetrics
import android.graphics.Movie


fun Context.getAnimation(animResId: Int): XmlResourceParser =
        resources().getAnimation(animResId)

fun Context.getBoolean(booleanResId: Int): Boolean =
        resources().getBoolean(booleanResId)

fun Context.getColor(colorResId: Int): Int =
        resources().getColor(colorResId)

fun Context.getColorStateList(stateListResId: Int): ColorStateList =
        resources().getColorStateList(stateListResId)

fun Context.getDimension(dimenResId: Int): Float =
        resources().getDimension(dimenResId)

fun Context.getIntArray(id: Int): IntArray =
        resources().getIntArray(id)

fun Context.getDisplayMetrics(): DisplayMetrics =
        resources().getDisplayMetrics()

fun Context.getInteger(id: Int): Int =
        resources().getInteger(id)

fun Context.getLayout(id: Int): XmlResourceParser =
        resources().getLayout(id)

fun Context.getMovie(id: Int): Movie =
        resources().getMovie(id)

fun Context.getQuantityString(id: Int, quantity: Int, vararg formatArgs: Any): String =
        resources().getQuantityString(id, quantity, formatArgs)

fun Context.getQuantityString(id: Int, quantity: Int): String =
        resources().getQuantityString(id, quantity)

fun Context.getQuantityText(id: Int, quantity: Int): CharSequence =
        resources().getQuantityText(id, quantity)

fun Context.getStringArray(arrayResId: Int): Array<String> =
        resources().getStringArray(arrayResId)

fun Context.typefaceFromAssets(assetPathResId: Int): Typeface =
        typefaceFromAssets(getString(assetPathResId))

fun Context.typefaceFromAssets(assetPath: String): Typeface =
        Typeface.createFromAsset(getAssets(), assetPath)

/*
 * -----------------------------------------------------------------------------
 *  Private methods
 * -----------------------------------------------------------------------------
 */
private fun Context.resources(): Resources = this.getResources()
