package com.example.cleanarchitecturestudy.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
//import dagger.hilt.android.qualifiers.ApplicationContext
//import javax.inject.Inject


class NetworkManager /*@Inject*/ constructor(/*@ApplicationContext*/ private val context: Context) {

    fun checkNetworkState(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val now = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(now) ?: return false

        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }
}