package com.yule.ui

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by yule
 * on 2022/9/8
 * desc :
 */
class BaseRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RecyclerView(context, attrs, defStyle) {

    init {
        layoutManager = LinearLayoutManager(context)
    }

    fun setupLinearLayout(orientation: Int) {
        layoutManager = LinearLayoutManager(context).apply {
            this.orientation = orientation
        }
    }
}