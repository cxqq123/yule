package com.cx.libx_biz_base.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.cx.lib_base.utils.YLog
import com.cx.libx_biz_base.base.BaseActivity
import com.cx.libx_biz_base.base.BaseFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by yule
 * on 2022/6/14
 * description :
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {
    companion object {
        fun <T : BaseViewModel> activity(activity: BaseActivity, vmClass: Class<T>): T {
            return ViewModelProvider(activity)[vmClass]
        }

        fun <T : BaseViewModel> fragment(fragment: BaseFragment, vmClass: Class<T>): T {
            return ViewModelProvider(fragment)[vmClass]
        }
    }

    fun launchUI(block : suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch() {
            try {
                block()
            } catch (e : Exception) {
                YLog.e("launchUI : ${e.localizedMessage}")
            }
        }
    }
}