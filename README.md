Android Kotlin Extensions
=========================
A collection of Kotlin extensions for Android

Save Preferences
-------------------------
**Java - Single Preference**
````java
public class WalkthroughActivity extends Activity {

  private void saveWalkthroughPreference(boolean complete) {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    Editor editor = preferences.edit();
    editor.putBoolean("KEY_WALKTHROUGH_COMPLETE", complete);
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
      editor.commit();
    } else {
      editor.apply();
    }
  }
}
````

**Kotlin - Single Preference (with extensions)**
````kotlin
public class WalkthroughActivity : Activity() {
  ...

  fun saveWalkthroughPreference(complete: Boolean) {
    // From a Context implementation
    getDefaultSharedPreferences().putBoolean("KEY_WALKTHROUGH_COMPLETE", complete)
  }
}
````

**Kotlin - Bulk Preferences (with extensions)**
````kotlin
getDefaultSharedPreferences().bulk()
  .putBoolean("KEY_WALKTHROUGH_COMPLETE", complete)
  .putString("KEY_LAST_USED", lastUsedIso8601Date)
  .applyBulk()
````

Show Toast
-------------------------
**Java**
````java
Toast.makeText(this, R.string.welcome, Toast.LENGTH_SHORT).show();
````

**Kotlin (with extensions)**
````kotlin
// From a Context implementation
showShortToast(R.string.welcome)
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
