package com.cx.libx_biz_base

/**
 * Created by yule
 * on 2022/9/8
 * desc :
 */
data class ApiResult(
    var data : Any?,
    var errorCode : Int,
    var errorMsg : String?= ""
)