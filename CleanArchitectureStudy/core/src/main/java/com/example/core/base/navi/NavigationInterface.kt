package com.example.core.base.navi

import android.content.Context

interface NavigationInterface {
    fun changeActivity(context: Context, fromActivity: String)
}