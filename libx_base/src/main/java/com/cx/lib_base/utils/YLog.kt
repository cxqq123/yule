package com.cx.lib_base.utils

import android.text.TextUtils
import android.util.Log

/**
 * Created by yule
 * on 2022/6/14
 * description :
 */
object YLog {
    private const val TAG = "YLog"

    fun v(message: String?) {
        if (!TextUtils.isEmpty(message)) {
            Log.v(TAG, message!!)
        }
    }

    fun d(message: String?) {
        if (!TextUtils.isEmpty(message)) {
            Log.d(TAG, message!!)
        }
    }

    fun i(message: String?) {
        if (!TextUtils.isEmpty(message)) {
            Log.i(TAG, message!!)
        }
    }

    fun w(message: String?) {
        if (!TextUtils.isEmpty(message)) {
            Log.w(TAG, message!!)
        }
    }

    fun e(message: String?) {
        if (!TextUtils.isEmpty(message)) {
            Log.e(TAG, message!!)
        }
    }

    fun showStackTrace() {
        val recordMethodName = Thread.currentThread().stackTrace
        d("className = ${recordMethodName[4].className}" +
                " fileName = ${recordMethodName[4].fileName}" +
                " lineNumber = ${recordMethodName[4].lineNumber}" +
                " methodName = ${recordMethodName[4].methodName}")
    }
}