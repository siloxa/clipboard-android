package tech.siloxa.clipboard.utils

import android.content.pm.PackageManager
import tech.siloxa.clipboard.base.ApplicationLoader

object DebugUtils {

    fun isDebuggable(): Boolean {
        return try {
            val pm = ApplicationLoader.context.packageManager
            val appInfo = pm.getApplicationInfo(
                ApplicationLoader.context.packageName,
                0
            )
            (appInfo.flags and android.content.pm.ApplicationInfo.FLAG_DEBUGGABLE) != 0
        } catch (e: PackageManager.NameNotFoundException) {
            // Handle exception if package is not found
            false
        }
    }
}