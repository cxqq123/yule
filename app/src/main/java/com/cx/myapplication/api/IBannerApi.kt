package com.cx.myapplication.api

import com.cx.libx_biz_base.Constants
import com.cx.myapplication.bean.BannerResult
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by yule
 * on 2022/9/8
 * desc :
 */
interface IBannerApi {

    @GET(Constants.API_BANNER)
    fun getBanner() : Call<BannerResult>
}