package com.mobsandgeeks.kaffeine.showcase

import android.content.Context
import android.view.View
import android.widget.TextView
import com.mobsandgeeks.kaffeine.KaffeineAdapter
import com.mobsandgeeks.kaffeine.ViewBinder
import com.mobsandgeeks.kaffeine.ViewHolder
import java.util.ArrayList


class CricketAdapter(c: Context, l: Int, i: ArrayList<CricketTeam>, b: CricketTeamBinder)
        : KaffeineAdapter<CricketTeam, CricketTeamViewHolder, CricketTeamBinder>(c, l, i, b) {

    override fun createHolder(view: View): CricketTeamViewHolder {
        return CricketTeamViewHolder(view)
    }
}

class CricketTeamViewHolder(view: View) : ViewHolder(view) {
    var teamNameTextView: TextView = view.findViewById(R.id.teamNameTextView) as TextView
    var captainTextView: TextView = view.findViewById(R.id.captainTextView) as TextView
}

class CricketTeamBinder : ViewBinder<CricketTeamViewHolder, CricketTeam> {

    override fun bind(viewHolder: CricketTeamViewHolder, item: CricketTeam) {
        viewHolder.teamNameTextView.setText(item.name)
        viewHolder.captainTextView.setText(item.captain)
    }
}
