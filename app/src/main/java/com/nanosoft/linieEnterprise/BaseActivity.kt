package com.nanosoft.linieEnterprise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Vijay on 3/12/19.
 */

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        init()

    }

    abstract fun getLayout(): Int
    abstract fun init()


}