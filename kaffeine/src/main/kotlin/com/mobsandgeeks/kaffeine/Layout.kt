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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


public fun Context.inflateLayout(layoutResId: Int): View =
        inflateView(this, layoutResId, null, false)

public fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup): View =
        inflateLayout(layoutResId, parent, true)

public fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup, attachToRoot: Boolean): View =
        inflateView(this, layoutResId, parent, attachToRoot)

/*
 * -----------------------------------------------------------------------------
 *  Private functions
 * -----------------------------------------------------------------------------
 */
private fun inflateView(context: Context, layoutResId: Int, parent: ViewGroup?,
        attachToRoot: Boolean): View =
                LayoutInflater.from(context).inflate(layoutResId, parent, attachToRoot)
