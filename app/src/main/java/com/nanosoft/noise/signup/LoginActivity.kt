package com.nanosoft.noise.signup

import android.os.Bundle
import android.view.View
import com.nanosoft.noise.R
import com.nanosoft.noise.base.BaseActivity
import com.nanosoft.noise.utils.Navigator
import com.nanosoft.noise.utils.validateTextIsNotEmpty
import kotlinx.android.synthetic.main.activity_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnRegister.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnRegister -> {
                if (validateTextIsNotEmpty(edtMobileNumber.text.toString())) {
                    btnRegister.setText(getString(R.string.txt_login))
                    showProgress(this)

                    if (btnRegister.text.toString().equals(getString(R.string.txt_login))) {
//                        callLoginApi()
                    } else {
//                        callRegisterApi()
                    }

                } else {
                    showToastMessage(getString(R.string.error_empty_field))
                }
            }
        }
    }

    private fun callRegisterApi() {
        mCustomerService?.registerUser(edtMobileNumber.text.toString())
            ?.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    hideProgress()
                    showToastMessage("Mobile number registered")
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    showToastMessage(getString(R.string.error_something_went_wrong))
                }
            })
    }

    private fun callLoginApi() {
        mCustomerService?.doLogin(edtMobileNumber.text.toString())
            ?.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    hideProgress()
                    showToastMessage("Mobile number registered")
                    Navigator.navigateToDashboardActivity(this@LoginActivity)
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    showToastMessage(getString(R.string.error_something_went_wrong))
                }
            })
    }

}
