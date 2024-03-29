package com.cx.libx_biz_base.tools

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.zhihu.matisse.engine.ImageEngine

/**
 * Created by yule
 * on 2022/2/22
 * description :
 */
class GlideLoadEngine : ImageEngine {
    override fun loadThumbnail(
        context: Context,
        resize: Int,
        placeholder: Drawable?,
        imageView: ImageView,
        uri: Uri?
    ) {
        Glide.with(context).asBitmap().load(uri).apply(object : RequestOptions() {
            init {
                override(resize, resize)
                placeholder(placeholder)
                centerCrop()
            }
        }).into(imageView)
    }

    override fun loadGifThumbnail(
        context: Context,
        resize: Int,
        placeholder: Drawable?,
        imageView: ImageView,
        uri: Uri?
    ) {
        Glide.with(context).asBitmap().load(uri).apply(object : RequestOptions() {
            init {
                override(resize, resize)
                placeholder(placeholder)
                centerCrop()
            }
        }).into(imageView)
    }

    override fun loadImage(
        context: Context,
        resizeX: Int,
        resizeY: Int,
        imageView: ImageView,
        uri: Uri?
    ) {
        Glide.with(context).load(uri).apply(object : RequestOptions() {
            init {
                override(resizeX, resizeY)
                priority(Priority.HIGH)
                fitCenter()
            }
        }).into(imageView)
    }

    override fun loadGifImage(
        context: Context,
        resizeX: Int,
        resizeY: Int,
        imageView: ImageView,
        uri: Uri?
    ) {
        Glide.with(context).asGif().load(uri).apply(object : RequestOptions() {
            init {
                override(resizeX, resizeY)
                priority(Priority.HIGH)
                fitCenter()
            }
        }).into(imageView)
    }

    override fun supportAnimatedGif(): Boolean = true
}