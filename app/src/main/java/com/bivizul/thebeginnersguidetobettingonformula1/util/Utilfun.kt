package com.bivizul.thebeginnersguidetobettingonformula1.util

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import com.bivizul.thebeginnersguidetobettingonformula1.R
import java.text.SimpleDateFormat
import java.util.*

fun getSetBehome(context: Context): Locale = context.resources.configuration.locales[0]

fun getDialogExit(context: Context, activity: Activity) {
    AlertDialog.Builder(context).apply {
        setTitle(context.getString(R.string.title_error))
        setMessage(context.getString(R.string.error_message))

        setPositiveButton(context.getString(R.string.quit)) { _, _ ->
            activity.finishAndRemoveTask()
            System.exit(0)
        }
        setCancelable(true)
    }.create().show()
}

fun getCapid(pref: SharedPreferences): String {
    var capid = pref.getString("behome", "noBehome") ?: "noBehome"
    if (capid == "noBehome") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        capid = datetime + randomNum
        pref.edit().putString("behome", capid).apply()
    }
    return capid
}

fun checkConMan(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}


