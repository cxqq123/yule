package com.cx.myapplication.biz.mine

import com.cx.libx_biz_base.base.BaseVBFragment
import com.cx.myapplication.databinding.MineFragmentBinding

/**
 * Created by yule
 * on 2022/9/9
 * desc : 我的页面
 */
class MineFragment : BaseVBFragment<MineFragmentBinding>(){

    companion object {
        fun newInstance() : MineFragment {
            return MineFragment()
        }
    }
}