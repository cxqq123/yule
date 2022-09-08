package com.cx.libx_biz_base.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.viewbinding.ViewBinding
import com.cx.lib_base.utils.Utils
import java.lang.reflect.InvocationTargetException

/**
 * Created by yule
 * on 2022/9/8
 * desc :
 */
open class BaseVBFragment<VB: ViewBinding> : BaseFragment() {

    protected lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vb = createViewBinding(this)
        return if (vb != null) {
            binding = vb
            binding.root
        } else {
            super.onCreateView(inflater, container, savedInstanceState)
            throw IllegalStateException("binding init failed")
        }
    }

    /**
     * createViewBinding for activity
     */
    @Nullable
    fun createViewBinding(fragment: BaseVBFragment<VB>): VB? {
        val cls: Class<*>? = Utils.getInterfaceClass(fragment.javaClass, 0)
        try {
            if (cls == null) return null
            val inflate = cls.getDeclaredMethod("inflate", LayoutInflater::class.java)
            return inflate.invoke(null, fragment.layoutInflater) as VB
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