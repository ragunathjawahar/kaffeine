package com.mobsandgeeks.shorthand.showcase

import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.TextView
import com.mobsandgeeks.shorthand.*


public class ShorthandActivity : Activity(), DialogInterface.OnClickListener {
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
        val evenNumbers = arrayList.filter { number: Int -> number % 2 == 0 }
/*
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.app_name)
        builder.setMessage(evenNumbers.toString())
        builder.setPositiveButton(android.R.string.ok, object: DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface, which: Int) {
                showShortToast("Hello World!")
            }
        })
        builder.create().show()
*/

        val array = arrayListOf("Hello", "World", "How", "Are", "You")
        val arrayAdapter = ArrayAdapter(this@ShorthandActivity,
                android.R.layout.simple_list_item_1, array)

        val sampleDialog = alertDialog {
            titleId = R.string.app_name
            cancelable = true

            adapter(arrayAdapter) { dialog, which ->
                showShortToast(arrayAdapter.getItem(which))
            }

            positiveButton(android.R.string.ok) { dialog, which ->
                showShortToast(evenNumbers.toString())
            }

            negativeButton("Cancel") { dialog, which ->
                showShortToast("Cancelled")
            }

            neutralButton("Neutral") { dialog, which ->
                showLongToast("The deepest places in hell are reserved "
                        + "for those who maintain "
                        + "neutrality at times of moral crisis.")
            }

            onDismissListener {
                showShortToast("Dismissed :P")
            }

            onCancelListener {
                showShortToast("Cancelled ;)")
            }
        }

        helloWorldTextView?.setOnClickListener { sampleDialog.show() }

        /*
        AlertDialog.Builder(this)
            .setTitle(R.string.app_name)
            .setMessage("Divine Comedy!")
            .setCancelable(false)
            .setAdapter(arrayAdapter) { dialog, which ->
                showShortToast(arrayAdapter.getItem(which))
            }
            .create()
            .show()
        */
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
