package com.nanosoft.noise

import android.app.Application
import com.facebook.stetho.Stetho


/**
 * Created by Vijay on 26/2/19.
 */

@Suppress("DEPRECATION")
class UserApplication : Application() {

    companion object{

        var mAppContext: UserApplication? = null

        fun getAppInstance(): UserApplication {
            return mAppContext!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        mAppContext = this
        Stetho.initializeWithDefaults(this)
    }



}