package com.cx.myapplication.bean

import java.io.Serializable

/**
 * Created by yule
 * on 2022/9/8
 * desc :
 */

data class BannerResult (
    val data : List<BannerBean>
) : Serializable

data class BannerBean (
    var desc : String,
    var id : Long,
    var imagePath : String,
    var isVisible : Int,
    var order : Int,
    var title : String,
    var type : Int,
    var url : String
) : Serializable {
    override fun toString(): String {
        return "BannerBean(desc='$desc', id=$id, imagePath='$imagePath', isVisible=$isVisible, order=$order, title='$title', type=$type, url='$url')"
    }
}