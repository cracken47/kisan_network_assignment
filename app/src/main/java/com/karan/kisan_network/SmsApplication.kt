package com.karan.kisan_network

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class SmsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}
