package com.cx.lib_base.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by yule
 * on 2022/9/8
 * desc :
 */
object ToastUtil {

    fun toast(context : Context, message : String?= ""){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}