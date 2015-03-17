package com.mobsandgeeks.ake

import android.content.Context
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup


fun Context.inflateLayout(layoutResId: Int): View =
        inflateView(this, layoutResId, null, false)

fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup): View =
        inflateLayout(layoutResId, parent, true)

fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup, attachToRoot: Boolean): View =
        inflateView(this, layoutResId, parent, attachToRoot)

/*
 * -----------------------------------------------------------------------------
 *  Private methods
 * -----------------------------------------------------------------------------
 */
private fun inflateView(context: Context, layoutResId: Int, parent: ViewGroup?,
        attachToRoot: Boolean): View =
                LayoutInflater.from(context).inflate(layoutResId, parent, attachToRoot)
