package com.mobsandgeeks.ake

import android.content.Context
import android.content.Intent
import android.app.Activity
import android.app.Service
import android.os.Bundle


inline public fun <reified T : Activity> Activity.startActivity() {
    this.startActivity(getIntent<T>())
}

inline public fun <reified T: Activity> Activity.startActivity(extras: Bundle) {
    this.startActivity(getIntent<T>(extras))
}

inline public fun <reified T : Activity> Activity.startActivityForResult(requestCode: Int) {
    this.startActivityForResult(getIntent<T>(), requestCode)
}

inline public fun <reified T : Activity> Service.startActivity() {
    val intent = getIntent<T>()
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    this.startActivity(intent)
}

inline public fun <reified T: Activity> Service.startActivity(extras: Bundle) {
    val intent = getIntent<T>(extras);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    this.startActivity(intent)
}

inline public fun <reified T: Service> Context.startService() {
    this.startService(getIntent<T>())
}

inline public fun <reified T: Service> Context.startService(extras: Bundle) {
    this.startService(getIntent<T>(extras))
}

inline public fun <reified T: Context> Context.getIntent(): Intent {
    return Intent(this, javaClass<T>())
}

inline public fun <reified T: Context> Context.getIntent(extras: Bundle): Intent {
    val intent = Intent(this, javaClass<T>())
    intent.putExtras(extras)
    return intent
}
