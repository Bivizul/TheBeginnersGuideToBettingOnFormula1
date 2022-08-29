package com.bivizul.thebeginnersguidetobettingonformula1.util

import android.content.ComponentName
import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsServiceConnection
import androidx.browser.customtabs.CustomTabsSession

fun behomeTab(context: Context, uri: String) {

    val behomeCustomTabsServiceConnection: CustomTabsServiceConnection?
    var behomeClient: CustomTabsClient?
    var behomeCustomTabsSession: CustomTabsSession? = null
    behomeCustomTabsServiceConnection = object : CustomTabsServiceConnection() {
        override fun onCustomTabsServiceConnected(
            componentName: ComponentName,
            customTabsClient: CustomTabsClient,
        ) {
            behomeClient = customTabsClient
            behomeClient?.warmup(0L)
            behomeCustomTabsSession = behomeClient?.newSession(null)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            behomeClient = null
        }
    }
    CustomTabsClient.bindCustomTabsService(
        context,
        "com.android.chrome",
        behomeCustomTabsServiceConnection
    )

    val customTabsIntent = CustomTabsIntent.Builder(behomeCustomTabsSession)
        .setShowTitle(true)
        .build()

    customTabsIntent.launchUrl(context, Uri.parse(uri))

}