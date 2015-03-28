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

package com.mobsandgeeks.support.v7

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


private class BuildableRecyclerViewAdapter<M, H : RecyclerView.ViewHolder>(
        val context: Context,
        val layoutId: Int,
        val holderMaker: (view: View) -> H,
//        val viewTypeMapper: (item: M, position: Int) -> Int,
        val binder: ((holder: H, item: M, Int) -> Unit)) : RecyclerView.Adapter<H>() {

    private var layoutInflater = LayoutInflater.from(context)
    private var items: List<M>? = null
    private var itemsArray: Array<M>? = null

    constructor(context: Context,
                layoutId: Int,
                holderMaker: (view: View) -> H,
                binder: ((H, M, Int) -> Unit), items: List<M>)
                : this(context, layoutId, holderMaker, binder) {

        this.items = items
    }

    constructor(context: Context,
                layoutId: Int,
                holderMaker: (view: View) -> H,
                binder: ((H, M, Int) -> Unit),
                itemsArray: Array<M>)
                : this(context, layoutId, holderMaker, binder) {

        this.itemsArray = itemsArray
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): H? {
        val view = layoutInflater.inflate(layoutId, parent, false) // TODO Supply appropriate view
        return holderMaker(view)
    }

    override fun onBindViewHolder(holder: H, position: Int) {
        val item: M = (if (items != null) items?.get(position)
                else itemsArray?.get(position))!!
        binder(holder, item, position)
    }

    override fun getItemCount(): Int {
        return (if (items != null) items?.size() else itemsArray?.size())!!
    }
}

/*
class CricketTeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var teamNameTextView: TextView = view.find<TextView>(R.id.teamNameTextView)
    var captainTextView: TextView = view.find<TextView>(R.id.captainTextView)
}

class CricRecylerAdapter(val context: Context, val teams: List<CricketTeam>)
        : RecyclerView.Adapter<CricRecyclerHolder>() {
    val layoutInflater = context.layoutInflater()

    override fun onCreateViewHolder(parent: ViewGroup?, position: Int): CricRecyclerHolder {
        val view = layoutInflater.inflate(R.layout.list_item_cricket_team, parent, false)
        return CricRecyclerHolder(view)
    }

    override fun onBindViewHolder(holder: CricRecyclerHolder, position: Int) {
        val team = teams.get(position)
        holder.teamTextView.setText(team.name)
        holder.captainTextView.setText(team.captain)
    }

    override fun getItemCount(): Int {
        return teams.size()
    }
}

annotation class CricketTeam

class CricRecyclerHolder(view: View) : RecyclerView.ViewHolder(view) {
    var teamTextView: TextView = view.find(R.id.teamNameTextView)
    var captainTextView: TextView = view.find(R.id.captainTextView)
}
*/
