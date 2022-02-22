package com.cx.myapplication.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import java.lang.Exception

/**
 * Created by yule
 * on 2022/2/22
 * description :
 */
object DeviceUtils {

    private var displayMetrics: DisplayMetrics? = null

    fun dp2px(context: Context, dp: Float): Int {
        return (dp * density(context) + 0.5f) as Int
    }

    private fun density(context: Context): Float {
        return if (getDisplayMetrics(context) == null) {
            3.0f
        } else getDisplayMetrics(context)?.density ?: 0f
    }


    private fun getDisplayMetrics(context: Context): DisplayMetrics? {
        if (displayMetrics == null) {
            try {
                displayMetrics = DisplayMetrics()
                val windowManager =
                    context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
                windowManager.defaultDisplay.getRealMetrics(displayMetrics)
                if (displayMetrics!!.heightPixels <= 640 || displayMetrics!!.widthPixels <= 360) {
                    displayMetrics =
                        context.applicationContext.resources.displayMetrics
                }
            } catch (e: Exception) {
            }
        }
        return displayMetrics
    }
}