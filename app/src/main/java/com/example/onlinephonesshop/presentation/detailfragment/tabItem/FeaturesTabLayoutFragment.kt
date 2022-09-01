package com.example.onlinephonesshop.presentation.detailfragment.tabItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlinephonesshop.R


class FeaturesTabLayoutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_features_tab_layout, container, false)
    }

    companion object{
        fun instance() = FeaturesTabLayoutFragment()
    }


}