package com.nanosoft.noise.dataProvider

import com.nanosoft.noise.signup.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Vijay on 3/12/19.
 */

interface CustomerService {

    @POST("register")
    @FormUrlEncoded
    fun registerUser(@Field("mobile") mobileNumber: String): Call<LoginResponse>

    @POST("login")
    @FormUrlEncoded
    fun doLogin(@Field("mobile") mobileNumber: String): Call<LoginResponse>

}