package com.mobsandgeeks.kaffeine.showcase

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import com.mobsandgeeks.kaffeine.adapter.ViewHolder
import com.mobsandgeeks.kaffeine.adapter.adapter
import com.mobsandgeeks.kaffeine.adapter.onItemClick
import com.mobsandgeeks.kaffeine.layoutInflater
import com.mobsandgeeks.kaffeine.view.find
import com.mobsandgeeks.kaffeine.view.showToastShort


data class CricketTeam(val name: String, val captain: String)

public class CricketTeamsActivity : Activity() {

    private val teams = arrayListOf(
            CricketTeam("CSK", "Dhoni"),
            CricketTeam("KKR", "Sharukh Khan"),
            CricketTeam("HSR", "Dyanathi Maran"),
            CricketTeam("KEP", "Preity Zinta"),
            CricketTeam("MI", "Sachin Tendulkar"),
            CricketTeam("Kochi", "Sendhil MG"),
            CricketTeam("India", "Dhoni"),
            CricketTeam("Sri Lanka", "Ranathunga"),
            CricketTeam("Australia", "Clarke"),
            CricketTeam("New Zealand", "Yavano"),
            CricketTeam("Canada", "King Kong")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cricket_teams_recycler_view)

        val cricketRecyclerView = findViewById(R.id.cricketTeamsRecyclerView) as RecyclerView

        cricketRecyclerView.setLayoutManager(LinearLayoutManager(this))
        cricketRecyclerView.setAdapter(CricRecylerAdapter(this, teams))

        /*
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

        // Event listeners
        cricketTeamsListView.onItemClick<CricketTeam> { team ->
            showToastShort(team.toString())
        }
        */
    }
}

class CricketTeamViewHolder(view: View) : ViewHolder(view) {
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

class CricRecyclerHolder(view: View) : RecyclerView.ViewHolder(view) {
    var teamTextView: TextView = view.find(R.id.teamNameTextView)
    var captainTextView: TextView = view.find(R.id.captainTextView)
}
