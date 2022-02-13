package com.example.core.base.navi

import android.content.Context

class Navigation(private val naviInterface: NavigationInterface) {
    operator fun invoke(
        context: Context,
        fromActivity: String
    ) = naviInterface.changeActivity(context, fromActivity)
}