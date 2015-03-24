package com.mobsandgeeks.shorthand.showcase

import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.mobsandgeeks.shorthand.getDefaultSharedPreferences
import com.mobsandgeeks.shorthand.putString
import com.mobsandgeeks.shorthand.showShortToast


public class ExtensionsActivity : Activity(), DialogInterface.OnClickListener {
    val KEY_PASSWORD = "KEY_PASSWORD"

    var helloWorldTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extensions)

        helloWorldTextView = findViewById(R.id.helloWorldTextView) as TextView

        val preferences = getDefaultSharedPreferences()

        var password = preferences.getString(KEY_PASSWORD, "none yet")
        showShortToast(password)

        preferences.putString(KEY_PASSWORD, "This is my secret!")
        password = preferences.getString(KEY_PASSWORD, "none yet")
        showShortToast(password)

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
