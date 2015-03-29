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

package com.mobsandgeeks.kaffeine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.mobsandgeeks.kaffeine.layoutInflater
import kotlin.properties.Delegates


public abstract class ViewHolder(val view: View)

public inline fun <M, H : ViewHolder> adapter(context: Context,
        init: AdapterBuilder<M, H>.() -> Unit): ArrayAdapter<M> {
    val adapterBuilder = AdapterBuilder<M, H>(context)
    adapterBuilder.init()
    return adapterBuilder.build();
}

public class AdapterBuilder<M, H : ViewHolder>(val context: Context) {
    var layoutId: Int = -1
    var holderMaker: ((view: View) -> H)? = null
    var binder: ((holder: H, item: M) -> Unit)? = null
    var items: List<M>? = null
    var itemsArray: Array<M>? = null

    public fun build(): ArrayAdapter<M> {
        if (layoutId == -1) throw IllegalStateException("You must set a valid 'layoutId'")
        if (holderMaker == null) throw IllegalStateException("'holder' cannot be null")
        if (binder == null) throw IllegalStateException("'binder' cannot be null")
        if (items == null && itemsArray == null)
                throw IllegalStateException("Non-null 'items' or 'itemsArray' is required")

        val adapter = if (items != null) BuildableAdapter<M, H>(context, layoutId, items!!)
                else BuildableAdapter<M, H>(context, layoutId, itemsArray!!)
        adapter.binder = this.binder!!
        adapter.holderMaker = holderMaker!!
        return adapter
    }
}

private class BuildableAdapter<M, H : ViewHolder> : ArrayAdapter<M> {
    private var layoutInflater: LayoutInflater by Delegates.notNull()
    private var layoutId: Int by Delegates.notNull()
    var binder: (holder: H, item: M) -> Unit by Delegates.notNull()
    var holderMaker: (view: View) -> H by Delegates.notNull()

    constructor(context: Context, layoutId: Int, items: List<M>)
            : super(context, layoutId, items) {
        initProperties(layoutId)
    }

    constructor(context: Context, layoutId: Int, items: Array<M>)
            : super(context, layoutId, items) {
        initProperties(layoutId)
    }

    private fun initProperties(layoutId: Int) {
        this.layoutInflater = getContext().layoutInflater()
        this.layoutId = layoutId
    }

    [suppress("UNCHECKED_CAST")]
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var view = convertView
        var viewHolder: H?

        if (view == null) {
            view = layoutInflater.inflate(layoutId, parent, false)
            viewHolder = holderMaker(view!!)
            view?.setTag(viewHolder)
        } else {
            viewHolder = view?.getTag() as H
        }

        var item: M = getItem(position)
        binder(viewHolder!!, item)

        return view
    }
}
