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
import android.widget.ArrayAdapter
import java.util.ArrayList


public abstract class ViewHolder(val view: View)

public trait ViewBinder<I, H : ViewHolder> {
    fun bind(item: I, viewHolder: H)
}

public abstract class KaffeineAdapter<I, H : ViewHolder, B : ViewBinder<I, H>> : ArrayAdapter<I> {
    private var layoutInflater: LayoutInflater? = null
    private var layoutId: Int? = null
    private var binder: B? = null

    constructor(context: Context, layoutId: Int, items: ArrayList<I>, binder: B)
            : super(context, layoutId, items) {
        initProperties(layoutId, binder)
    }

    constructor(context: Context, layoutId: Int, items: Array<I>, binder: B)
            : super(context, layoutId, items) {
        initProperties(layoutId, binder)
    }

    fun initProperties(layoutId: Int, binder: B) {
        this.layoutId = layoutId
        this.binder = binder
    }

    [suppress("UNCHECKED_CAST")]
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var view = convertView
        var viewHolder: H? = null

        if (view == null) {
            view = layoutInflater!!.inflate(layoutId!!, parent, false)
            viewHolder = createHolder(view!!)
            view?.setTag(viewHolder)
        } else {
            viewHolder = view?.getTag() as H
        }

        var item: I = getItem(position)
        binder!!.bind(item, viewHolder!!)

        return view
    }

    abstract fun createHolder(view: View): H
}
