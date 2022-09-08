package com.cx.lib_base.utils

import android.util.Log

/**
 * Created by yule
 * on 2022/9/8
 * desc :
 */
object LogUtil {

    private const val DEFAULT_TAG = "yule"

    fun v(message: String) {
        Log.v(DEFAULT_TAG, message)
    }

    fun d(message: String) {
        Log.d(DEFAULT_TAG, message)
    }

    fun i(message: String) {
        Log.i(DEFAULT_TAG, message)
    }

    fun w(message: String) {
        Log.w(DEFAULT_TAG, message)
    }

    fun e(message: String) {
        Log.e(DEFAULT_TAG, message)
    }
}