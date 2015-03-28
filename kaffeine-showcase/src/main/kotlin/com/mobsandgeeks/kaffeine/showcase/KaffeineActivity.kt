package com.mobsandgeeks.kaffeine.showcase

import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.TextView
import com.mobsandgeeks.kaffeine.getDefaultSharedPreferences
import com.mobsandgeeks.kaffeine.putString
import com.mobsandgeeks.kaffeine.stringArray
import com.mobsandgeeks.kaffeine.view.alertDialog
import com.mobsandgeeks.kaffeine.view.showToastLong
import com.mobsandgeeks.kaffeine.view.showToastShort


public class KaffeineActivity : Activity(), DialogInterface.OnClickListener {
    val KEY_PASSWORD = "KEY_PASSWORD"

    var helloWorldTextView: TextView? = null

    val appName: Array<String> by stringArray(R.array.dan_brown_books)

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extensions)

        helloWorldTextView = findViewById(R.id.helloWorldTextView) as TextView

        val preferences = getDefaultSharedPreferences()
        preferences.putString(KEY_PASSWORD, "This is my secret!")

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
        val arrayAdapter = ArrayAdapter(this@KaffeineActivity,
                android.R.layout.simple_list_item_1, array)

        val sampleDialog = alertDialog(this) {
            titleId = R.string.app_name
            cancelable = true

            singleChoiceItems(R.array.dan_brown_books, 2) { dialog, which ->
                showToastShort(arrayAdapter.getItem(which))
            }

            positiveButton(android.R.string.ok) { dialog, which ->
                showToastShort(evenNumbers.toString())
            }

            negativeButton("Cancel") { dialog, which ->
                showToastShort("Cancelled")
            }

            neutralButton("Neutral") { dialog, which ->
                showToastLong("The deepest places in hell are reserved "
                        + "for those who maintain "
                        + "neutrality at times of moral crisis.")
            }

            onDismissListener {
                showToastShort("Dismissed :P")
            }

            onCancelListener {
                showToastShort("Cancelled ;)")
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
