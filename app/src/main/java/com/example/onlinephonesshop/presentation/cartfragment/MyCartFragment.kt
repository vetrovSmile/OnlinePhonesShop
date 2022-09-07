package com.example.onlinephonesshop.presentation.cartfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.databinding.FragmentMyCartBinding
import com.example.onlinephonesshop.presentation.ApplicationApp
import com.example.onlinephonesshop.presentation.ViewModalFactoryFragment
import javax.inject.Inject


class MyCartFragment : Fragment() {

    private lateinit var binding: FragmentMyCartBinding
    private lateinit var viewModal: ViewModalCartFragment
    private lateinit var cartAdapter: CartFragmentAdapter
    private lateinit var progressBarCart: FrameLayout
    private lateinit var errorCart: FrameLayout
    private lateinit var retryCart: Button

    @Inject
    lateinit var viewModalFactory: ViewModalFactoryFragment

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
        binding = FragmentMyCartBinding.inflate(inflater, container, false)
        viewModal = ViewModelProvider(this, viewModalFactory)[ViewModalCartFragment::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        showProgressBar()
        initButtonBack()
        observerResponseCart()
        initCartRv()

    }

    private fun initView(view: View) {
        errorCart = view.findViewById(R.id.error_layout_cart)
        retryCart = view.findViewById(R.id.button_try)
        progressBarCart = requireActivity().findViewById(R.id.progress_bar_cart)
    }

    private fun observerResponseCart() {

        viewModal.getBasketItem()

        viewModal.viewStateCart.observe(viewLifecycleOwner) {
            if (it.isDownload) hideProgressBar()
            else if (it.e != null) showException()
        }
        viewModal.basketItemResponse.observe(viewLifecycleOwner) { response ->

            response.body()?.let {
                val basketList = it.basket
                cartAdapter.list = basketList.toMutableList()
                binding.costText.text = it.total.toDouble().toString()
            }
        }

    }

    private fun initCartRv() {
        val cartRv = binding.rvBasket
        cartAdapter = CartFragmentAdapter()
        cartRv.adapter = cartAdapter
    }

    private fun initButtonBack() {
        binding.backButtonBascet.setOnClickListener {
            findNavController().navigate(R.id.action_myCartFragment_to_detailsFragment)
        }
    }

    private fun showProgressBar() {
        progressBarCart.visibility = View.VISIBLE


    }

    private fun hideProgressBar() {
        progressBarCart.visibility = View.INVISIBLE


    }

    private fun showException() {
        errorCart.visibility = View.VISIBLE
        retryCart.setOnClickListener {
            viewModal.getBasketItem()
            errorCart.visibility = View.INVISIBLE
        }

    }

}