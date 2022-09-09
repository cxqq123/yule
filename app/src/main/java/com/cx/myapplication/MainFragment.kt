package com.cx.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cx.libx_biz_base.base.BaseActivity
import com.cx.libx_biz_base.base.BaseVBFragment
import com.cx.myapplication.biz.home.HomePageFragment
import com.cx.myapplication.biz.mine.MineFragment
import com.cx.myapplication.biz.square.SquareFragment
import com.cx.myapplication.databinding.MainFragmentBinding

/**
 * Created by yule
 * on 2022/9/9
 * desc :
 */
class MainFragment : BaseVBFragment<MainFragmentBinding>(){

    companion object {
        const val TAB_COUNT = 3

        const val TAB_HOME = 0
        const val TAB_SQUARE = 1
        const val TAB_MINE = 2
        fun newInstance() : MainFragment {
            return MainFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setListener()
    }

    private fun initView() {
        binding.viewPager.adapter = MainFragmentAdapter(activity as BaseActivity)
        binding.viewPager.currentItem = TAB_HOME
    }

    private fun setListener() {
        binding.home.setOnClickListener {
            switchTab(TAB_HOME)
        }

        binding.square.setOnClickListener {
            switchTab(TAB_SQUARE)
        }

        binding.mine.setOnClickListener {
            switchTab(TAB_MINE)
        }
    }

    private fun switchTab(tab : Int) {
        binding.viewPager.setCurrentItem(tab, false)
    }

    class MainFragmentAdapter(activity: BaseActivity) : FragmentStateAdapter(activity) {
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                TAB_HOME -> HomePageFragment.newInstance()
                TAB_SQUARE -> SquareFragment.newInstance()
                TAB_MINE -> MineFragment.newInstance()
                else -> HomePageFragment.newInstance()
            }
        }
        override fun getItemCount(): Int = TAB_COUNT
    }
}