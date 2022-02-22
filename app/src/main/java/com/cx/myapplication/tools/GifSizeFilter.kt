/*
 * Copyright 2017 Zhihu Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cx.myapplication.tools

import android.content.Context
import com.zhihu.matisse.internal.entity.IncapableCause
import com.zhihu.matisse.internal.utils.PhotoMetadataUtils
import com.cx.myapplication.R
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.filter.Filter
import com.zhihu.matisse.internal.entity.Item
import java.util.HashSet

class GifSizeFilter(
    private val mMinWidth: Int,
    private val mMinHeight: Int,
    private val mMaxSize: Int
) : Filter() {
    public override fun constraintTypes(): HashSet<MimeType?> {
        return object : HashSet<MimeType?>() {
            init {
                add(MimeType.GIF)
            }
        }
    }

    override fun filter(context: Context, item: Item): IncapableCause? {
        if (!needFiltering(context, item)) return null
        val size = PhotoMetadataUtils.getBitmapBound(context.contentResolver, item.contentUri)
        return if (size.x < mMinWidth || size.y < mMinHeight || item.size > mMaxSize) {
            IncapableCause(
                IncapableCause.DIALOG,
                context.getString(
                    R.string.error_gif,
                    mMinWidth,
                    PhotoMetadataUtils.getSizeInMB(mMaxSize.toLong()).toString()
                )
            )
        } else null
    }
}