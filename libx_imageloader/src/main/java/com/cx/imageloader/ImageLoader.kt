package com.cx.imageloader

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by yule
 * on 2022/9/8
 * desc :
 */
object ImageLoader {

    fun showImage(view : ImageView, url : String) {
        Glide.with(view).load(url).into(view)
    }

    fun showImage(view: ImageView, resId : Int) {
        Glide.with(view).load(resId).into(view)
    }
}