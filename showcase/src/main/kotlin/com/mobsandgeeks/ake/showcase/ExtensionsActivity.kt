package com.mobsandgeeks.ake.showcase

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.content.DialogInterface
import com.mobsandgeeks.ake.getDefaultSharedPreferences
import com.mobsandgeeks.ake.putString
import com.mobsandgeeks.ake.showShortToast
import android.widget.TextView
import butterknife.bindView


public class ExtensionsActivity : Activity(), DialogInterface.OnClickListener {
    val helloWorldTextView: TextView by bindView(R.id.helloWorldTextView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extensions)

        val keyPrefPassword = "password"
        val preferences = getDefaultSharedPreferences()

        var password = preferences.getString(keyPrefPassword, "none yet")
        showShortToast(password)

        preferences.putString(keyPrefPassword, "This is my secret!")
        password = preferences.getString(keyPrefPassword, "none yet")
        showShortToast(password)

        val view = View(this)
        view.setOnClickListener { (view: View) ->
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        }

        val arrayList = arrayListOf(1, 2, 3, 4, 5, 6, 7)
        val evenNumbers = arrayList.filter() { (number: Int) -> number % 2 == 0 }
        println(evenNumbers)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.menu_extensions, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        if (id == R.id.action_settings) {
            return true
        }

        return super<Activity>.onOptionsItemSelected(item)
    }

    override fun onClick(dialog: DialogInterface, which: Int) {
        throw UnsupportedOperationException()
    }
}
