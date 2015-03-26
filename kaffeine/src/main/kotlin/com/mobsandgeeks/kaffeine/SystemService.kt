/*
 * Copyright (C) 2015 Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mobsandgeeks.kaffeine

import android.content.Context
import android.app.AlarmManager
import android.view.accessibility.AccessibilityManager
import android.accounts.AccountManager
import android.app.ActivityManager
import android.appwidget.AppWidgetManager
import android.app.AppOpsManager
import android.media.AudioManager
import android.os.BatteryManager
import android.bluetooth.BluetoothAdapter
import android.hardware.camera2.CameraManager
import android.view.accessibility.CaptioningManager
import android.content.ClipboardManager
import android.net.ConnectivityManager
import android.hardware.ConsumerIrManager
import android.app.admin.DevicePolicyManager
import android.hardware.display.DisplayManager
import android.app.DownloadManager
import android.os.DropBoxManager
import android.view.inputmethod.InputMethodManager
import android.hardware.input.InputManager
import android.app.job.JobScheduler
import android.app.KeyguardManager
import android.content.pm.LauncherApps
import android.view.LayoutInflater
import android.location.LocationManager
import android.media.projection.MediaProjectionManager
import android.media.MediaRouter
import android.media.session.MediaSessionManager
import android.nfc.NfcManager
import android.app.NotificationManager
import android.net.nsd.NsdManager
import android.os.PowerManager
import android.print.PrintManager
import android.content.RestrictionsManager
import android.app.SearchManager
import android.hardware.SensorManager
import android.os.storage.StorageManager
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.textservice.TextServicesManager
import android.media.tv.TvInputManager
import android.app.UiModeManager
import android.hardware.usb.UsbManager
import android.os.UserManager
import android.os.Vibrator
import android.service.wallpaper.WallpaperService
import android.net.wifi.p2p.WifiP2pManager
import android.net.wifi.WifiManager
import android.view.WindowManager


public fun Context.accessibilityManager(): AccessibilityManager? =
        getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

public fun Context.accountManager(): AccountManager? =
        getSystemService(Context.ACCOUNT_SERVICE) as AccountManager

public fun Context.activityManager(): ActivityManager =
        getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

public fun Context.alarmManager(): AlarmManager =
        getSystemService(Context.ALARM_SERVICE) as AlarmManager

public fun Context.appWidgetManager(): AppWidgetManager? =
        getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager

public fun Context.appOpsManager(): AppOpsManager? =
        getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

public fun Context.audioManager(): AudioManager =
        getSystemService(Context.AUDIO_SERVICE) as AudioManager

public fun Context.batteryManager(): BatteryManager? =
        getSystemService(Context.BATTERY_SERVICE) as BatteryManager

public fun Context.bluetoothAdapter(): BluetoothAdapter? =
        getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothAdapter

public fun Context.cameraManager(): CameraManager? =
        getSystemService(Context.CAMERA_SERVICE) as CameraManager

public fun Context.captioningManager(): CaptioningManager? =
        getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager

public fun Context.clipboardManager(): ClipboardManager =
        getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

public fun Context.connectivityManager(): ConnectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

public fun Context.consumerIrManager(): ConsumerIrManager? =
        getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager

public fun Context.devicePolicyManager(): DevicePolicyManager? =
        getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

public fun Context.displayManager(): DisplayManager? =
        getSystemService(Context.DISPLAY_SERVICE) as DisplayManager

public fun Context.downloadManager(): DownloadManager? =
        getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

public fun Context.dropBoxManager(): DropBoxManager? =
        getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager

public fun Context.inputMethodManager(): InputMethodManager? =
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

public fun Context.inputManager(): InputManager? =
        getSystemService(Context.INPUT_SERVICE) as InputManager

public fun Context.jobScheduler(): JobScheduler? =
        getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

public fun Context.keyguardManager(): KeyguardManager =
        getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

public fun Context.launcherApps(): LauncherApps? =
        getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps

public fun Context.layoutInflater(): LayoutInflater =
        getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

public fun Context.locationManager(): LocationManager =
        getSystemService(Context.LOCATION_SERVICE) as LocationManager

public fun Context.mediaProjectionManager(): MediaProjectionManager? =
        getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

public fun Context.mediaRouter(): MediaRouter? =
        getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter

public fun Context.mediaSessionManager(): MediaSessionManager? =
        getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager

public fun Context.nfcManager(): NfcManager? =
        getSystemService(Context.NFC_SERVICE) as NfcManager

public fun Context.notificationManager(): NotificationManager =
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

public fun Context.nsdManager(): NsdManager? =
        getSystemService(Context.NSD_SERVICE) as NsdManager

public fun Context.powerManager(): PowerManager =
        getSystemService(Context.POWER_SERVICE) as PowerManager

public fun Context.printManager(): PrintManager? =
        getSystemService(Context.PRINT_SERVICE) as PrintManager

public fun Context.restrictionsManager(): RestrictionsManager? =
        getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager

public fun Context.searchManager(): SearchManager =
        getSystemService(Context.SEARCH_SERVICE) as SearchManager

public fun Context.sensorManager(): SensorManager =
        getSystemService(Context.SENSOR_SERVICE) as SensorManager

public fun Context.storageManager(): StorageManager? =
        getSystemService(Context.STORAGE_SERVICE) as StorageManager

public fun Context.telecomManager(): TelecomManager? =
        getSystemService(Context.TELECOM_SERVICE) as TelecomManager

public fun Context.telephonyManager(): TelephonyManager =
        getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

public fun Context.textServicesManager(): TextServicesManager? =
        getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager

public fun Context.tvInputManager(): TvInputManager? =
        getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager

public fun Context.uiModeManager(): UiModeManager? =
        getSystemService(Context.UI_MODE_SERVICE) as UiModeManager

public fun Context.usbManager(): UsbManager? =
        getSystemService(Context.USB_SERVICE) as UsbManager

public fun Context.userManager(): UserManager? =
        getSystemService(Context.USER_SERVICE) as UserManager

public fun Context.vibrator(): Vibrator =
        getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

public fun Context.wallpaperService(): WallpaperService =
        getSystemService(Context.WALLPAPER_SERVICE) as WallpaperService

public fun Context.wifiP2pManager(): WifiP2pManager? =
        getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager

public fun Context.wifiManager(): WifiManager =
        getSystemService(Context.WIFI_SERVICE) as WifiManager

public fun Context.windowService(): WindowManager =
        getSystemService(Context.WINDOW_SERVICE) as WindowManager

/*
 * -----------------------------------------------------------------------------
 *  Private functions
 * -----------------------------------------------------------------------------
 */
private fun Context.getSystemService(serviceName: String): Any? =
        this.getSystemService(serviceName)
