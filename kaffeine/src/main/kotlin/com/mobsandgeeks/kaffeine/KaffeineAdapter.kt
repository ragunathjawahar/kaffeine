package com.mobsandgeeks.kaffeine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import java.util.ArrayList


public abstract class ViewHolder(val view: View)

public trait ViewBinder<H : ViewHolder, I> {
    fun bind(viewHolder: H, item: I)
}

abstract class KaffeineAdapter<I, H : ViewHolder, B : ViewBinder<H, I>>(
        context: Context, val layoutId: Int, val items: ArrayList<I>, val binder: B)
                : ArrayAdapter<I>(context, layoutId, items) {

    private var layoutInflater: LayoutInflater = context.layoutInflater()

    [suppress("UNCHECKED_CAST")]
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var view = convertView
        var viewHolder: H? = null

        if (view == null) {
            view = layoutInflater.inflate(layoutId, parent, false)
            viewHolder = createHolder(view!!)
            view?.setTag(viewHolder)
        } else {
            viewHolder = view?.getTag() as H
        }

        var item: I = getItem(position)
        binder.bind(viewHolder!!, item)

        return view
    }

    abstract fun createHolder(view: View): H
}
