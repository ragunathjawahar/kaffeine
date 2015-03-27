package com.mobsandgeeks.kaffeine.showcase

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import com.mobsandgeeks.kaffeine.getStringArray
import com.mobsandgeeks.kaffeine.onItemClick
import com.mobsandgeeks.kaffeine.showToastShort


public class CricketTeamsActivity : Activity() {
    private var cricketTeamsListView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cricket_teams)

        // UI References
        cricketTeamsListView = findViewById(R.id.cricketTeamsListView) as ListView

        // Adapter
        val cricketTeams = getStringArray(R.array.cricket_teams)
        var cricketAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cricketTeams)
        cricketTeamsListView?.setAdapter(cricketAdapter)

        // Event listeners
        cricketTeamsListView!!.onItemClick<String> { team ->
            showToastShort(team)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.menu_cricket_teams, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
