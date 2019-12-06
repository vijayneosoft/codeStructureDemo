package com.nanosoft.noise.base

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nanosoft.noise.R
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
    var progressDialog: ProgressDialog? = null

    init {
        mPreferenceManager = PreferenceManager()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        mCustomerService = ApiService.getInstance().call()
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

    fun showToastMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    fun showProgress(context: Context) {

        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(context, null, null, true, false)
            progressDialog!!.setContentView(R.layout.custom_dialog)
            progressDialog!!.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            //progressDialog.setProgressStyle(R.style.popupStyle);
            progressDialog!!.setCancelable(true)
        }
    }

    fun hideProgress() {
        if (progressDialog != null && progressDialog?.isShowing()!!) {
            progressDialog?.dismiss()
            progressDialog = null
        }
        // LoadingDialog.dismissLast();
    }


}