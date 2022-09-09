package com.cx.myapplication

import android.os.Bundle
<<<<<<< HEAD
import com.cx.libx_biz_base.base.BaseVBActivity
import com.cx.myapplication.databinding.MainActivityBinding

class MainActivity : BaseVBActivity<MainActivityBinding>() {
=======
import com.cx.libx_biz_base.base.BaseActivity
import com.cx.libx_biz_base.viewmodel.BannerViewModel
import com.cx.libx_biz_base.viewmodel.BaseViewModel
import com.cx.myapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
>>>>>>> 3e9666b ([feat]新增 libx_design_mode 设计模式模块)

    private lateinit var vm : BannerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
<<<<<<< HEAD
        supportFragmentManager.beginTransaction().replace(R.id.fl_container, MainFragment.newInstance()).commitAllowingStateLoss()
=======
        vm = BaseViewModel.activity(this, BannerViewModel::class.java)
        vm.getBanner()
>>>>>>> 3e9666b ([feat]新增 libx_design_mode 设计模式模块)
    }
}