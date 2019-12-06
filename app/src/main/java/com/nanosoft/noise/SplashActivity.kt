package com.nanosoft.noise

import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.nanosoft.noise.base.BaseActivity
import com.nanosoft.noise.utils.Constants
import com.nanosoft.noise.utils.Navigator


/**
 * Created by Vijay on 4/12/19.
 */

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var isUserRegistered = mPreferenceManager?.getBoolean(Constants.KEY_USER_REGISTERED)
        Log.d("splash", "" + isUserRegistered)

        Handler().postDelayed({
            if (isUserRegistered!!) {
                Navigator.navigateToDashboardActivity(this)
                finish()
            } else {
                Navigator.navigateToLoginActivity(this)
                finish()
            }
        }, 2000)

    }

}