package com.example.documentlist

import android.app.Application
import com.example.documentlist.activity.MainActivity
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        VK.addTokenExpiredHandler(tokenTracker)
    }

    private val tokenTracker = object : VKTokenExpiredHandler {
        override fun onTokenExpired() {
            MainActivity.startFrom(this@SampleApplication)
        }
    }
}
