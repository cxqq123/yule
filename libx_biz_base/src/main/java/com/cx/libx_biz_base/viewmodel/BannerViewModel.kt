package com.cx.libx_biz_base.viewmodel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by yule
 * on 2022/6/14
 * description :
 */
class BannerViewModel : BaseViewModel(){

    fun getBanner() = launchUI {
        val apiResult = withContext(Dispatchers.IO) {

        }
    }
}