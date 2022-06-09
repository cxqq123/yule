//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build.VERSION

object ClipboardUtil {
    private const val MAX_RETRY_TIME = 3
    private const val FIRST_TIME_DELAY = 20
    private const val DELAY_TIME_ADD = 20
    fun copy(context: Context, text: String?) {
        copy(context, "Tape", text)
    }

    fun copy2(context: Context, text: String?) {
        copy(context, "Tape2", text)
    }

    @SuppressLint("WrongConstant")
    fun copy(context: Context, label: String?, text: String?) {
        val manager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        if (manager != null) {
            val data = ClipData.newPlainText(label, text)
            try {
                manager.setPrimaryClip(data)
            } catch (var5: Throwable) {
            }
        }
    }

    @SuppressLint("WrongConstant")
    fun clear(context: Context) {
        val manager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        if (manager != null) {
            if (VERSION.SDK_INT > 28) {
                manager.clearPrimaryClip()
            } else {
                manager.setPrimaryClip(
                    ClipData.newPlainText(
                        "abc",
                        ""
                    )
                )
            }
        }
    }

    @SuppressLint("WrongConstant")
    fun getFirstItem(context: Context): CharSequence {
        val manager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        if (manager != null) {
            val data = manager.primaryClip
            if (data != null) {
                val item = data.getItemAt(0)
                return item.text
            }
        }
        return ""
    }

    @SuppressLint("WrongConstant")
    fun getClipData(context: Context, clipCallback: GetClipCallback) {
        try {
            val clipboardManager =
                context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = clipboardManager?.primaryClip
            clipCallback.execute(clipData)
        } catch (var3: Throwable) {
            var3.printStackTrace()
        }
    }

    fun getFirstData(clipData: ClipData?): String {
        var data: CharSequence? = null
        if (clipData != null && clipData.itemCount > 0) {
            data = clipData.getItemAt(0).text
        }
        return data?.toString() ?: ""
    }

    fun getDataList(clipData: ClipData?): List<CharSequence?> {
        val datas: MutableList<CharSequence?> = mutableListOf()
        if (clipData != null && clipData.itemCount > 0) {
            for (i in 0 until clipData.itemCount) {
                val item = clipData.getItemAt(i)
                datas.add(item.text)
            }
        }
        return datas
    }

    interface GetClipCallback {
        fun execute(clipData: ClipData?)
    }
}