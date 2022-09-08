package com.cx.libx_biz_base.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.Nullable
import androidx.viewbinding.ViewBinding
import com.cx.lib_base.utils.Utils
import java.lang.reflect.InvocationTargetException

/**
 * Created by yule
 * on 2022/9/8
 * desc :
 */
open class BaseVBActivity<VB : ViewBinding> : BaseActivity() {

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!::binding.isInitialized) {
            val vb = createViewBinding(this)
            if (vb != null) {
                binding = vb
                setContentView(binding.root)
            } else {
                throw IllegalStateException("binding init failed")
            }
        }
    }

    fun setContentView(binding: VB) {
        this.binding = binding
        setContentView(binding.root)
    }

    /**
     * createViewBinding for activity
     */
    @Nullable
    fun createViewBinding(activity: BaseVBActivity<VB>): VB? {
        val cls: Class<*>? = Utils.getInterfaceClass(activity.javaClass, 0)
        try {
            if (cls == null) return null
            val inflate = cls.getDeclaredMethod("inflate", LayoutInflater::class.java)
            return inflate.invoke(null, activity.layoutInflater) as VB
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        return null
    }
}