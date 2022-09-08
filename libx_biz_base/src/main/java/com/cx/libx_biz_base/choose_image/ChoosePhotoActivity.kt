package com.cx.libx_biz_base.choose_image

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.cx.libx_biz_base.tools.GifSizeFilter
import com.cx.libx_biz_base.tools.GlideLoadEngine
import com.cx.libx_biz_base.databinding.ActivityChoosePhotoBinding
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.filter.Filter
import com.zhihu.matisse.internal.entity.CaptureStrategy

/**
 * Created by yule
 * on 2022/4/13
 * description :
 */
class ChoosePhotoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChoosePhotoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoosePhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.btnPhoto.setOnClickListener {
            choosePhoto()
        }
    }

    private fun choosePhoto() {
        Matisse.from(this)
            .choose(MimeType.ofImage(), false)
            .countable(true)
            .capture(true)
            .captureStrategy(
                CaptureStrategy(true, "com.cx.myapplication.fileprovider", "test")
            )
            .maxSelectable(9)
            .addFilter(GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
            .gridExpectedSize(
                 120
            )
            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            .thumbnailScale(0.85f)
            .imageEngine(GlideLoadEngine())
            .setOnSelectedListener { uriList, pathList ->
            }
            .showSingleMediaType(true)
            .originalEnable(true)
            .maxOriginalSize(10)
            .autoHideToolbarOnSingleTap(true)
            .setOnCheckedListener { isChecked ->
            }
            .forResult(REQ_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_CODE) {
            if (resultCode == RESULT_OK) {
                val uri = Matisse.obtainResult(data)[0]
                Glide.with(this)
                    .asBitmap() // some .jpeg files are actually gif
                    .load(uri)
                    .apply(object : RequestOptions() {
                        init {
                            override(SIZE_ORIGINAL)
                        }
                    })
                    .into(binding.ivImg)
            } else {
                Toast.makeText(this, "uri is null", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val REQ_CODE = 1
    }
}