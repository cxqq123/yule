package com.cx.lib_base.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors

/**
 * Created by yule
 * on 2022/4/24
 * description :
 */
class CountDown<T>(
    private var duration : Long, // 倒计时长
    private var interval : Long, // 倒计时间隔
    private val action : (Long) -> T // 倒计时后台任务
) {

    // 任务结果累加值
    var acc: Any ?= null
    // 倒计时剩余时间
    private var remainTime = duration
    // 任务开始回调
    var onStart: (() -> Unit) ?= null
    // 任务结束回调
    var onEnd: (() -> Unit) ?= null
    // 任务结果累加器
    var accumulator : ((T, T) -> T) ?= null

    // 倒计时任务包装类
    private val countdownRunnable by lazy { CountDownRunnable() }
    // 用户主线程回调的 Handler
    private val handler by lazy { Handler(Looper.getMainLooper()) }
    // 线程池
    private val executor by lazy { Executors.newSingleThreadScheduledExecutor() }

    // 启动倒计时
    private inner class CountDownRunnable : Runnable {
        override fun run() {
            remainTime -= interval
            // 执行后台任务并获取返回值
            val value = action(remainTime)
            // 累加任务返回值
            acc = if (acc == null) value else accumulator?.invoke(acc as T, value)
            if (remainTime <= 0) {
                // 关闭倒计时
            }
        }
    }
}