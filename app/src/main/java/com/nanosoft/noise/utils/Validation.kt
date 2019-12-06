package com.nanosoft.noise.utils

import android.text.TextUtils

/**
 * Created by Vijay on 4/12/19.
 */

fun validateTextIsNotEmpty(string: String): Boolean {
    if (!TextUtils.isEmpty(string)) {
        return true
    }
    return false
}