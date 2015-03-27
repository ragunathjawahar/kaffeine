package com.mobsandgeeks.kaffeine.showcase

import android.app.Activity
import android.os.Bundle
import android.widget.ListView
import com.mobsandgeeks.kaffeine.adapter
import com.mobsandgeeks.kaffeine.onItemClick
import com.mobsandgeeks.kaffeine.showToastShort


data class CricketTeam(val name: String, val captain: String)

public class CricketTeamsActivity : Activity() {

    private val teams = arrayListOf(CricketTeam("CSK", "Dhoni"), CricketTeam("RCB", "Kholi"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cricket_teams)

        // UI References
        val cricketTeamsListView = findViewById(R.id.cricketTeamsListView) as ListView

        // Adapter
        var cricketAdapter = adapter<CricketTeam, CricketTeamViewHolder>(this) {
            layoutId = R.layout.list_item_cricket_team
            holderMaker = { CricketTeamViewHolder(it) }
            binder = { holder, team ->
                holder.teamNameTextView.setText(team.name)
                holder.captainTextView.setText(team.captain)
            }
            items = teams
        }

        cricketTeamsListView.setAdapter(cricketAdapter)
        cricketTeamsListView.onItemClick<CricketTeam> { team ->
            showToastShort(team.toString())
        }
    }
}
