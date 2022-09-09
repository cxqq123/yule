package com.cx.myapplication.biz.square

import android.os.Bundle
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cx.imageloader.ImageLoader
import com.cx.libx_biz_base.Constants
import com.cx.libx_biz_base.base.BaseVBFragment
import com.cx.myapplication.R
import com.cx.myapplication.api.IBannerApi
import com.cx.myapplication.bean.BannerBean
import com.cx.myapplication.bean.BannerResult
import com.cx.myapplication.databinding.SquareFragmentBinding
import com.cx.network.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by yule
 * on 2022/9/9
 * desc : 广场页面
 */
class SquareFragment : BaseVBFragment<SquareFragmentBinding>() {

    companion object {
        fun newInstance() : SquareFragment {
            return SquareFragment()
        }
    }

    private var adapter: BaseQuickAdapter<BannerBean, BaseViewHolder> ?= null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        requestBanner()
    }

    private fun initView() {
        adapter = object : BaseQuickAdapter<BannerBean, BaseViewHolder>(R.layout.item_banner) {
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

            }
        })
    }
}