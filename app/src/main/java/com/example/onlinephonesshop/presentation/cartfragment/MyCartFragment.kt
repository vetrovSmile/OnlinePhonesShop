package com.example.onlinephonesshop.presentation.cartfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.databinding.FragmentMyCartBinding
import com.example.onlinephonesshop.domain.entities.cartscreen.Basket
import com.example.onlinephonesshop.presentation.ApplicationApp
import com.example.onlinephonesshop.presentation.ViewModalFactoryFragment
import javax.inject.Inject


class MyCartFragment : Fragment() {

    private lateinit var binding: FragmentMyCartBinding
    private lateinit var viewModal: ViewModalCartFragment
    private lateinit var cartAdapter: CartFragmentAdapter

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
        initButtonBack()
        observerResponseCart()
        initCartRv()

    }
    private fun observerResponseCart(){
        viewModal.getBasketItem()
        viewModal.basketItemResponse.observe(viewLifecycleOwner){ response ->

            if (response.isSuccessful){
                response.body()?.let {
                    val basketList = it.basket
                    cartAdapter.list = basketList

                    binding.costText.text = it.total.toDouble().toString()
                }
            }

        }

    }

    private fun initCartRv(){
        val cartRv = binding.rvBasket
        cartAdapter = CartFragmentAdapter()
        cartRv.adapter = cartAdapter


    }

    private fun initButtonBack(){
        binding.backButtonBascet.setOnClickListener {
            findNavController().navigate(R.id.action_myCartFragment_to_detailsFragment)
        }
    }


}