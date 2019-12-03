package com.nanosoft.noise.dataProvider

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Created by Vijay on 3/12/19.
 */

class ApiService {

    companion object {

        var apiService: ApiService? = null
        private var retrofit: Retrofit? = null
        lateinit var services: CustomerService

        fun getInstance(): ApiService {

            if (apiService == null) {
                synchronized(ApiService::class.java) {

                    apiService = ApiService()
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                    val httpClient = OkHttpClient.Builder()
                    httpClient.addInterceptor(interceptor)
                    httpClient.networkInterceptors().add(StethoInterceptor())
                    httpClient.connectTimeout(3600, TimeUnit.MINUTES)

                    httpClient.readTimeout(3600, TimeUnit.MINUTES)


                    httpClient.addInterceptor(object : Interceptor {
                        @Throws(IOException::class)
                        override fun intercept(chain: Interceptor.Chain): Response {
                            val original = chain.request()

                            var requestBuilder = original.newBuilder()

                            /*requestBuilder = requestBuilder.header("Accept", "application/json")
                            .method(original.method(), original.body())*/

                            val request = requestBuilder.build()
                            return chain.proceed(request)
                        }
                    })

                    val gson = GsonBuilder()
                        .setLenient()
                        .create()
                    retrofit = Retrofit.Builder()
//                    .baseUrl(Constants.BASE_URL_NOISE)
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()


                }
            }
            return apiService!!
        }
    }

    fun call(): CustomerService {
        services = retrofit!!.create(CustomerService::class.java)
        return services
    }


}