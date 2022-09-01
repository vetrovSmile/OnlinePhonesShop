package com.example.onlinephonesshop.presentation.detailfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.databinding.FragmentDetailsBinding
import com.example.onlinephonesshop.presentation.ApplicationApp
import com.example.onlinephonesshop.presentation.ViewModalFactoryFragment
import com.example.onlinephonesshop.presentation.detailfragment.tabItem.DetailsTabLayoutFragment
import com.example.onlinephonesshop.presentation.detailfragment.tabItem.FeaturesTabLayoutFragment
import com.example.onlinephonesshop.presentation.detailfragment.tabItem.ShopTabLayoutFragment
import com.example.onlinephonesshop.presentation.detailfragment.tabItem.TabDetailsAdapter
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModal: ViewModalDetailFragment
    private lateinit var detailsPhotoAdapter: DetailAdapter
    private lateinit var favoriteButton: MaterialButton
    private lateinit var progressBarDetails: FrameLayout
    private lateinit var tabLayoutDetails: TabLayout
    private lateinit var viewPagerTabDetail: ViewPager2
    private var isFavorite = false


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
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        viewModal = ViewModelProvider(this, viewModalFactory)[ViewModalDetailFragment::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeDetailViewModal()
        initRv()
        initTabLayoutDetails()
        initFavoriteButton()
        initNavigateButton()

    }

    private fun observeDetailViewModal() {

        viewModal.getDetailListInfo()

        progressBarDetails = requireActivity().findViewById(R.id.progress_bar_detail)
        progressBarDetails.visibility = View.VISIBLE

        viewModal.viewStateMain.observe(viewLifecycleOwner) {
            if (it.isDownload) progressBarDetails.visibility = View.INVISIBLE
        }

        viewModal.getDetailList.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    val toList = listOf(it)
                    detailsPhotoAdapter.submitList(toList)
                }

            }

        }
    }

    private fun initTabLayoutDetails() {
        tabLayoutDetails = requireActivity().findViewById(R.id.tab_layout_details)
        viewPagerTabDetail = requireActivity().findViewById(R.id.viewPager_tab)

        val tabItem = listOf(
            ShopTabLayoutFragment.instance(),
            DetailsTabLayoutFragment.instance(),
            FeaturesTabLayoutFragment.instance()
        )
        val tabAdapter = TabDetailsAdapter(parentFragmentManager, lifecycle, tabItem)
        viewPagerTabDetail.adapter = tabAdapter
        TabLayoutMediator(tabLayoutDetails, viewPagerTabDetail) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.shop)
                1 -> tab.text = getString(R.string.details)
                2 -> tab.text = getString(R.string.features)
            }

        }.attach()

    }


    private fun initRv() {

        val detailRv = binding.viewPagerDetails
        detailsPhotoAdapter = DetailAdapter()
        detailRv.adapter = detailsPhotoAdapter

    }

    private fun initNavigateButton() {
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_mainFragment)
        }
        binding.basketButton.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_myCartFragment)
        }
    }

    private fun initFavoriteButton() {

        favoriteButton = requireActivity().findViewById(R.id.favorite_button_details)
        favoriteButton.setOnClickListener {
            isFavorite = if (isFavorite) {
                favoriteButton.setIconResource(R.drawable.ic_favorite_details_on)
                false
            } else {
                favoriteButton.setIconResource(R.drawable.ic_favorite_details_off)
                true
            }

        }

    }

}