package com.nanosoft.noise.utils

import android.content.Context
import android.content.Intent
import com.nanosoft.noise.signup.RegistrationActivity

/**
 * Created by Vijay on 3/12/19.
 */

class Navigator {

    companion object {

        fun navigateToSignInActivity(context: Context) {
            return context.startActivity(Intent(context, RegistrationActivity::class.java))
        }

    }


}