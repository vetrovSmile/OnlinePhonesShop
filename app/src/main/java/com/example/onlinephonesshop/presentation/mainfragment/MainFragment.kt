package com.example.onlinephonesshop.presentation.mainfragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.databinding.FragmentMainBinding
import com.example.onlinephonesshop.presentation.ApplicationApp
import com.example.onlinephonesshop.presentation.ViewModalFactoryFragment
import javax.inject.Inject


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModal: ViewModalMainFragment
    private lateinit var categoryAdapter: CategoryAdapter

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
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        viewModal = ViewModelProvider(this, viewModalFactory)[ViewModalMainFragment::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCategoryRv()
        viewModal.getListCategory()

        viewModal.category.observe(viewLifecycleOwner){
            categoryAdapter.listCategory = it
        }
    }

    private fun initCategoryRv(){
        val categoryRv = binding.recyclerViewCategory
        categoryAdapter = CategoryAdapter()
        categoryRv.adapter = categoryAdapter

    }
}