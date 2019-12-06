package com.nanosoft.noise.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nanosoft.noise.R
import com.nanosoft.noise.base.BaseActivity
import com.nanosoft.noise.dashboard.fragment.HomeFragment
import com.nanosoft.noise.dashboard.fragment.SettingsFragment

/**
 * Created by Vijay on 4/12/19.
 */

@SuppressLint("Registered")
class DashboardActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        replaceFragment(
            R.id.dashboard_container,
            HomeFragment()
        )

//        mPreferenceManager?.saveBoolean(Constants.KEY_USER_REGISTERED, true)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_settings -> {
                replaceFragment(
                    R.id.dashboard_container,
                    SettingsFragment()
                )
                return true
            }
        }


        return false

    }

}