package com.cx.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cx.imageloader.ImageLoader
import com.cx.lib_base.utils.ToastUtil
import com.cx.libx_biz_base.Constants
import com.cx.myapplication.api.IBannerApi
import com.cx.myapplication.bean.BannerBean
import com.cx.myapplication.bean.BannerResult
import com.cx.myapplication.databinding.ActivityMainBinding
import com.cx.network.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: BaseQuickAdapter<BannerBean, BaseViewHolder> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        requestBanner()
    }

    private fun initView() {
        adapter = object : BaseQuickAdapter<BannerBean, BaseViewHolder>(R.layout.banner_item) {
            override fun convert(holder: BaseViewHolder, item: BannerBean) {
                ImageLoader.showImage(holder.getView(R.id.iv_cover), item.imagePath)
                holder.setText(R.id.tv_title, item.title)
                holder.setText(R.id.tv_desc, item.desc)
            }
        }
        binding.rvBanner.adapter = adapter
    }

    private fun requestBanner() {
        val api = RetrofitHelper.createRequest(Constants.BASE_URL, IBannerApi::class.java)
        api?.getBanner()?.enqueue(object : Callback<BannerResult> {
            override fun onResponse(call: Call<BannerResult>, response: Response<BannerResult>) {
                adapter?.setNewInstance(response.body()?.data as MutableList<BannerBean>)
            }

            override fun onFailure(call: Call<BannerResult>, t: Throwable) {
                ToastUtil.toast(this@MainActivity, t.message)
            }
        })
    }
}