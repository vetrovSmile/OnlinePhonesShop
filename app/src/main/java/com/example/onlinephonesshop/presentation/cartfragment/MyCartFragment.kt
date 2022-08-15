package com.example.onlinephonesshop.presentation.cartfragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.databinding.FragmentMyCartBinding
import com.example.onlinephonesshop.presentation.ApplicationApp
import com.example.onlinephonesshop.presentation.ViewModalFactoryFragment
import javax.inject.Inject


class MyCartFragment : Fragment() {

    private lateinit var binding: FragmentMyCartBinding
    private lateinit var viewModal: ViewModalCartFragment

    @Inject
    lateinit var viewModalFactory:ViewModalFactoryFragment

    private val component by lazy {
        (requireActivity().application as ApplicationApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyCartBinding.inflate(inflater,container,false)
        viewModal = ViewModelProvider(this, viewModalFactory)[ViewModalCartFragment::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}