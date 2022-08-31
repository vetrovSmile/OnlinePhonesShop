package com.example.onlinephonesshop.presentation.detailfragment.tabItem

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabDetailsAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val tabList: List<Fragment>
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = tabList.size

    override fun createFragment(position: Int): Fragment {
        return tabList[position]
    }
}