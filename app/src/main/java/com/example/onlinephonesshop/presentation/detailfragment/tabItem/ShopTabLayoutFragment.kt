package com.example.onlinephonesshop.presentation.detailfragment.tabItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.databinding.FragmentShopTabLayoutBinding


class ShopTabLayoutFragment : Fragment() {

    private lateinit var binding: FragmentShopTabLayoutBinding
    private var colorChange = false
    private var memoryButton = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShopTabLayoutBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        colorButtonInit()
        memoryButtonInit()

    }

    private fun memoryButtonInit() {

        with(binding) {

            radioButtonMemory128.setOnClickListener {
                memoryButton = if (memoryButton) {

                    radioButtonMemory128.isChecked = true
                    radioButtonMemory256.isChecked = false
                    false
                } else {
                    radioButtonMemory128.isChecked = true
                    radioButtonMemory256.isChecked = false
                    true
                }
            }
            radioButtonMemory256.setOnClickListener {
                memoryButton = if (memoryButton) {
                    radioButtonMemory128.isChecked = false
                    radioButtonMemory256.isChecked = true
                    true
                } else {
                    radioButtonMemory128.isChecked = false
                    radioButtonMemory256.isChecked = true

                    false
                }
            }
        }
    }

    private fun colorButtonInit() {

        with(binding) {

            buttonColorBraun.setOnClickListener {
                colorChange = if (colorChange) {
                    buttonColorBlue.setIconResource(R.drawable.ic_select_icon_on)
                    buttonColorBraun.setIconResource(R.drawable.ic_select_icon_off)
                    false
                } else {
                    buttonColorBraun.setIconResource(R.drawable.ic_select_icon_on)
                    buttonColorBlue.setIconResource(R.drawable.ic_select_icon_off)
                    true
                }

            }
            buttonColorBlue.setOnClickListener {
                colorChange = if (colorChange) {
                    buttonColorBraun.setIconResource(R.drawable.ic_select_icon_off)
                    buttonColorBlue.setIconResource(R.drawable.ic_select_icon_on)
                    false
                } else {
                    buttonColorBraun.setIconResource(R.drawable.ic_select_icon_on)
                    buttonColorBlue.setIconResource(R.drawable.ic_select_icon_off)
                    true
                }

            }
        }


    }

    companion object {
        fun instance() = ShopTabLayoutFragment()
    }


}