package com.mobsandgeeks.ake

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


fun Context.accessibilityManager(): AccessibilityManager? =
        getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

fun Context.accountManager(): AccountManager? =
        getSystemService(Context.ACCOUNT_SERVICE) as AccountManager

fun Context.activityManager(): ActivityManager =
        getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

fun Context.alarmManager(): AlarmManager =
        getSystemService(Context.ALARM_SERVICE) as AlarmManager

fun Context.appWidgetManager(): AppWidgetManager? =
        getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager

fun Context.appOpsManager(): AppOpsManager? =
        getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

fun Context.audioManager(): AudioManager =
        getSystemService(Context.AUDIO_SERVICE) as AudioManager

fun Context.batteryManager(): BatteryManager? =
        getSystemService(Context.BATTERY_SERVICE) as BatteryManager

fun Context.bluetoothAdapter(): BluetoothAdapter? =
        getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothAdapter

fun Context.cameraManager(): CameraManager? =
        getSystemService(Context.CAMERA_SERVICE) as CameraManager

fun Context.captioningManager(): CaptioningManager? =
        getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager

fun Context.clipboardManager(): ClipboardManager =
        getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

fun Context.connectivityManager(): ConnectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

fun Context.consumerIrManager(): ConsumerIrManager? =
        getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager

fun Context.devicePolicyManager(): DevicePolicyManager? =
        getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

fun Context.displayManager(): DisplayManager? =
        getSystemService(Context.DISPLAY_SERVICE) as DisplayManager

fun Context.downloadManager(): DownloadManager? =
        getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

fun Context.dropBoxManager(): DropBoxManager? =
        getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager

fun Context.inputMethodManager(): InputMethodManager? =
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

fun Context.inputManager(): InputManager? =
        getSystemService(Context.INPUT_SERVICE) as InputManager

fun Context.jobScheduler(): JobScheduler? =
        getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

fun Context.keyguardManager(): KeyguardManager =
        getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

fun Context.launcherApps(): LauncherApps? =
        getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps

fun Context.layoutInflater(): LayoutInflater =
        getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

fun Context.locationManager(): LocationManager =
        getSystemService(Context.LOCATION_SERVICE) as LocationManager

fun Context.mediaProjectionManager(): MediaProjectionManager? =
        getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

fun Context.mediaRouter(): MediaRouter? =
        getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter

fun Context.mediaSessionManager(): MediaSessionManager? =
        getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager

fun Context.nfcManager(): NfcManager? =
        getSystemService(Context.NFC_SERVICE) as NfcManager

fun Context.notificationManager(): NotificationManager =
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

fun Context.nsdManager(): NsdManager? =
        getSystemService(Context.NSD_SERVICE) as NsdManager

fun Context.powerManager(): PowerManager =
        getSystemService(Context.POWER_SERVICE) as PowerManager

fun Context.printManager(): PrintManager? =
        getSystemService(Context.PRINT_SERVICE) as PrintManager

fun Context.restrictionsManager(): RestrictionsManager? =
        getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager

fun Context.searchManager(): SearchManager =
        getSystemService(Context.SEARCH_SERVICE) as SearchManager

fun Context.sensorManager(): SensorManager =
        getSystemService(Context.SENSOR_SERVICE) as SensorManager

fun Context.storageManager(): StorageManager? =
        getSystemService(Context.STORAGE_SERVICE) as StorageManager

fun Context.telecomManager(): TelecomManager? =
        getSystemService(Context.TELECOM_SERVICE) as TelecomManager

fun Context.telephonyManager(): TelephonyManager =
        getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

fun Context.textServicesManager(): TextServicesManager? =
        getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager

fun Context.tvInputManager(): TvInputManager? =
        getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager

fun Context.uiModeManager(): UiModeManager? =
        getSystemService(Context.UI_MODE_SERVICE) as UiModeManager

fun Context.usbManager(): UsbManager? =
        getSystemService(Context.USB_SERVICE) as UsbManager

fun Context.userManager(): UserManager? =
        getSystemService(Context.USER_SERVICE) as UserManager

fun Context.vibrator(): Vibrator =
        getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

fun Context.wallpaperService(): WallpaperService =
        getSystemService(Context.WALLPAPER_SERVICE) as WallpaperService

fun Context.wifiP2pManager(): WifiP2pManager? =
        getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager

fun Context.wifiManager(): WifiManager =
        getSystemService(Context.WIFI_SERVICE) as WifiManager

fun Context.windowService(): WindowManager =
        getSystemService(Context.WINDOW_SERVICE) as WindowManager

/*
 * -----------------------------------------------------------------------------
 *  Private methods
 * -----------------------------------------------------------------------------
 */
private fun Context.getSystemService(serviceName: String): Any? =
        this.getSystemService(serviceName)
