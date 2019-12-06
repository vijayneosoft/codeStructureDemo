package com.nanosoft.noise.utils

import android.app.Activity
import android.content.Intent
import com.nanosoft.noise.SplashActivity
import com.nanosoft.noise.dashboard.DashboardActivity
import com.nanosoft.noise.signup.LoginActivity
import com.nanosoft.noise.signup.LoginResponse
import retrofit2.Callback

/**
 * Created by Vijay on 3/12/19.
 */

class Navigator {

    companion object {

        fun navigateToLoginActivity(context: Activity) {
            return context.startActivity(Intent(context, LoginActivity::class.java))
        }

        fun navigateToDashboardActivity(context: Activity) {
            return context.startActivity(Intent(context, DashboardActivity::class.java))
        }


    }


}