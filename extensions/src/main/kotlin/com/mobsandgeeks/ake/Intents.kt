package com.mobsandgeeks.ake

import android.content.Context
import android.content.Intent
import android.app.Activity
import android.app.Service


public fun <T : Activity> Context.startActivity(activityClass: Class<T>) {
    this.startActivity(Intent(this, activityClass))
}

public fun <T: Service> Context.startService(serviceClass: Class<T>) {
    this.startService(Intent(this, serviceClass))
}
