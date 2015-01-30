package com.mobsandgeeks.ake

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface


public fun Context.getColor(colorResId: Int): Int {
    return resources().getColor(colorResId)
}

public fun Context.typefaceFromAssets(assetPath: String): Typeface {
    return Typeface.createFromAsset(getAssets(), assetPath)
}

/*
 * -----------------------------------------------------------------------------
 *  Private methods
 * -----------------------------------------------------------------------------
 */
private fun Context.resources(): Resources {
    return this.getResources()
}
