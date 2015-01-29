Android Kotlin Extensions
=========================
A collection of Kotlin extensions for Android

Preferences
-------------------------
<h4>Single Preference</h4>
**Java**
````java
SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
Editor editor = preferences.edit();
editor.putBoolean("KEY_WALKTHROUGH_COMPLETE", complete);
if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
  editor.commit();
} else {
  editor.apply();
}
````

**Kotlin**
````kotlin
// From a Context implementation
getDefaultSharedPreferences().putBoolean("KEY_WALKTHROUGH_COMPLETE", complete)
````

<h4>Bulk Preferences</h4>
**Kotlin - Bulk Preferences (with extensions)**
````kotlin
getDefaultSharedPreferences().bulk()
  .putBoolean("KEY_WALKTHROUGH_COMPLETE", complete)
  .putString("KEY_LAST_USED", lastUsedIso8601Date)
  .applyBulk()
````

Toasts
-------------------------
<h4>Short Message</h4>
**Java**
````java
Toast.makeText(this, R.string.welcome, Toast.LENGTH_SHORT).show();
````

**Kotlin (with extensions)**
````kotlin
// From a Context implementation
showShortToast(R.string.welcome)
````

<h4>Custom Toast</h4>
**Java**
````java
Toast toast = new Toast(this);
toast.setView(view);
toast.setDuration(Toast.LENGTH_LONG);
toast.show();
````

**Kotlin (with extensions)**
````kotlin
// From a Context implementation
showShortToast(view)
````

System Services
-------------------------
**Java**
````java
AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
````

**Kotlin (with extensions)**
````kotlin
// From a Context implementation
val alarmManager = context.alarmManager()
val notificationManager = context.notificationManager()
````

More...
-------------------------
More extensions under development.

License
-------------------------
    Copyright 2015 Mobs & Geeks

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
