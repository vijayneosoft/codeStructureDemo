package com.nanosoft.noise.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_base.*

/**
 * Created by Vijay on 3/12/19.
 */

abstract class BaseFragment : Fragment() {


    var mProgressDialog: ProgressDialog? = null

    abstract fun getLayout(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(getLayout(), container, false)
        // setFullScreenLoader()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

    fun showToastMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    fun showLoading() {
        progressBar?.visibility = View.VISIBLE
    }

    fun hideLoading() {
        progressBar?.visibility = View.GONE
    }

    fun setFullScreenLoader() {
        mProgressDialog = ProgressDialog(activity)
        mProgressDialog?.setCancelable(false)

    }
}