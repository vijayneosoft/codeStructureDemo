package com.nanosoft.noise.utils

import android.content.Context
import android.content.SharedPreferences
import com.nanosoft.noise.R
import com.nanosoft.noise.UserApplication

/**
 * Created by Vijay on 3/12/19.
 */

class PreferenceManager {

    var preferenceManger: PreferenceManager? = null
    var sharedPreferences: SharedPreferences? = null

    init {
        sharedPreferences = UserApplication.getAppInstance()
            .getSharedPreferences(
                UserApplication.getAppInstance().getString(R.string.preference_name),
                Context.MODE_PRIVATE
            )
    }

    fun saveString(key: String, value: String) {
        val editor = sharedPreferences?.edit()
        editor?.putString(key, value)
        editor?.commit()
        editor?.apply()
    }

    fun containsKey(key: String): Boolean {
        return sharedPreferences?.contains(key)!!
    }

    fun getString(key: String): String {
        return sharedPreferences?.getString(key, "")!!
    }

    fun saveInt(key: String, value: Int) {
        sharedPreferences?.edit()?.putInt(key, value)?.apply()
    }

    fun saveBoolean(key: String, value: Boolean) {
        sharedPreferences?.edit()?.putBoolean(key, value)?.apply()
    }

    fun getBoolean(key: String): Boolean? {
        return sharedPreferences?.getBoolean(key, false)
    }

    fun getInt(key: String): Int {
        return sharedPreferences?.getInt(key, 0)!!
    }

    fun clearString(key: String) {
        sharedPreferences?.edit()?.remove(key)
    }

}