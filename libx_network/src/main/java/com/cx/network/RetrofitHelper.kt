package com.cx.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by yule
 * on 2022/9/8
 * desc :
 */
class RetrofitHelper {

    companion object {
        private var instance : Retrofit ?= null

        private fun getInstance(baseUrl : String) : Retrofit? {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance
        }

        fun <T> createRequest(baseUrl: String, clazz: Class<T>) : T? {
            return getInstance(baseUrl)?.create(clazz)
        }
    }

}