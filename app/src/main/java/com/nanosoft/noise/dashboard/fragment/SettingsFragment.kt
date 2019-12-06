package com.nanosoft.noise.dashboard.fragment

import android.os.Bundle
import android.view.View
import com.nanosoft.noise.R
import com.nanosoft.noise.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_settings.*

/**
 * Created by Vijay on 5/12/19.
 */

class SettingsFragment : BaseFragment(), View.OnClickListener {
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.settings_logout -> {

            }
        }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_settings
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settings_logout.setOnClickListener(this)
    }

}