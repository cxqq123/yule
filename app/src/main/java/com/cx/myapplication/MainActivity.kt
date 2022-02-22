package com.cx.myapplication

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.cx.myapplication.databinding.ActivityMainBinding
import com.cx.myapplication.tools.GifSizeFilter
import com.cx.myapplication.tools.GlideLoadEngine
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.filter.Filter
import com.zhihu.matisse.internal.entity.CaptureStrategy

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
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
                resources.getDimensionPixelSize(R.dimen.grid_expected_size)
            )
            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            .thumbnailScale(0.85f)
            .imageEngine(GlideLoadEngine())
            .setOnSelectedListener { uriList, pathList ->
                Log.e("onSelected", "onSelected: pathList=$pathList")
            }
            .showSingleMediaType(true)
            .originalEnable(true)
            .maxOriginalSize(10)
            .autoHideToolbarOnSingleTap(true)
            .setOnCheckedListener { isChecked ->
                Log.e(
                    "isChecked",
                    "onCheck: isChecked=$isChecked"
                )
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