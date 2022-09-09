package com.cx.myapplication

import android.os.Bundle
import com.cx.libx_biz_base.base.BaseVBActivity
import com.cx.myapplication.databinding.MainActivityBinding

class MainActivity : BaseVBActivity<MainActivityBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        supportFragmentManager.beginTransaction().replace(R.id.fl_container, MainFragment.newInstance()).commitAllowingStateLoss()
    }
}