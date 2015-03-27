package com.mobsandgeeks.kaffeine.showcase

import android.content.Context
import android.view.View
import android.widget.TextView
import com.mobsandgeeks.kaffeine.KaffeineAdapter
import com.mobsandgeeks.kaffeine.ViewBinder
import com.mobsandgeeks.kaffeine.ViewHolder
import com.mobsandgeeks.kaffeine.find
import java.util.ArrayList


class CricketTeamViewHolder(view: View) : ViewHolder(view) {
    var teamNameTextView: TextView = view.find<TextView>(R.id.teamNameTextView)
    var captainTextView: TextView = view.find<TextView>(R.id.captainTextView)
}

class CricketTeamBinder : ViewBinder<CricketTeam, CricketTeamViewHolder> {

    override fun bind(item: CricketTeam, viewHolder: CricketTeamViewHolder) {
        viewHolder.teamNameTextView.setText(item.name)
        viewHolder.captainTextView.setText(item.captain)
    }
}

class CricketAdapter(c: Context, layout: Int, items: ArrayList<CricketTeam>, b: CricketTeamBinder)
        : KaffeineAdapter<CricketTeam, CricketTeamViewHolder, CricketTeamBinder>(
                c, layout, items, b) {

    override fun createHolder(view: View): CricketTeamViewHolder {
        return CricketTeamViewHolder(view)
    }
}
