package com.nanosoft.noise.base

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import com.nanosoft.noise.dataProvider.ApiService
import com.nanosoft.noise.dataProvider.CustomerService
import com.nanosoft.noise.utils.PreferenceManager
import kotlinx.android.synthetic.main.activity_base.*

/**
 * Created by Vijay on 3/12/19.
 */
@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    var mCustomerService: CustomerService? = null
    var mPreferenceManager: PreferenceManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPreferenceManager = PreferenceManager().getInstance()
        mCustomerService = ApiService.getInstance().call()
    }


    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        container?.addView(LayoutInflater.from(this).inflate(layoutResID, null))

    }

    fun replaceFragment(@IdRes containerViewId: Int, @NonNull fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(containerViewId, fragment)
            .commit()
    }

    fun isNetConnected(context: Context): Boolean {
        val mConnectivityManager = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val netInfo = mConnectivityManager.activeNetworkInfo
        return if (netInfo != null && netInfo.isConnectedOrConnecting) {
            true
        } else false

    }


}