package com.nanosoft.noise.userDetails

import android.annotation.SuppressLint
import android.os.Bundle
import com.nanosoft.noise.R
import com.nanosoft.noise.base.BaseActivity

/**
 * Created by Vijay on 5/12/19.
 */

@SuppressLint("Registered")
class UserDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
    }

}