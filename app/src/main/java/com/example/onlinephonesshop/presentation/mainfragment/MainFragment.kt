package com.example.onlinephonesshop.presentation.mainfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.databinding.FragmentMainBinding
import com.example.onlinephonesshop.presentation.ApplicationApp
import com.example.onlinephonesshop.presentation.ViewModalFactoryFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import javax.inject.Inject


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModal: ViewModalMainFragment
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var bestSellerAdapter: BestSellerAdapter
    private lateinit var sheetBottomDialog: BottomSheetDialog
    private lateinit var brandAutoComplete: AutoCompleteTextView
    private lateinit var priceAutoComplete: AutoCompleteTextView
    private lateinit var sizeAutoComplete: AutoCompleteTextView
    private lateinit var closeBottomSheet: ImageButton
    private lateinit var doneButtonSheet: Button
    private lateinit var sheetBottomDialogView: View
    private lateinit var progressBarMain: FrameLayout

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
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        viewModal = ViewModelProvider(this, viewModalFactory)[ViewModalMainFragment::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCategoryRv()
        bottomSheetInit()
        observeViewModal()

    }

    private fun observeViewModal() {

        viewModal.getListCategory()
        viewModal.getResponseMain()

        progressBarMain = requireActivity().findViewById(R.id.progress_bar)
        progressBarMain.visibility = View.VISIBLE

        viewModal.viewStateMain.observe(viewLifecycleOwner) {
            if (it.isDownload) progressBarMain.visibility = View.INVISIBLE
        }

        viewModal.category.observe(viewLifecycleOwner) {
            categoryAdapter.listCategory = it
        }

        viewModal.getResponseMainValue.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    val responseHome = it.home_store
                    val responseBestSeller = it.best_seller
                    homeAdapter.submitList(responseHome)
                    bestSellerAdapter.submitList(responseBestSeller)
                }

            }

        }

    }

    private fun bottomSheetInit() {

        sheetBottomDialog = BottomSheetDialog(requireActivity(), R.style.BottomSheetDialogFilter)
        sheetBottomDialogView = LayoutInflater.from(requireActivity()).inflate(
            R.layout.sheet_layout_filter,
            requireActivity().findViewById(R.id.filter_main_screen)
        )
        sheetBottomDialog.setContentView(sheetBottomDialogView)
        closeBottomSheet = sheetBottomDialogView.findViewById(R.id.button_close_filter)
        doneButtonSheet = sheetBottomDialogView.findViewById(R.id.button_done_filter)
        brandAutoComplete = sheetBottomDialogView.findViewById(R.id.AC_filter_brand)
        priceAutoComplete = sheetBottomDialogView.findViewById(R.id.AC_filter_price)
        sizeAutoComplete = sheetBottomDialogView.findViewById(R.id.AC_filter_size)
        closeBottomSheet.setOnClickListener {
            sheetBottomDialog.dismiss()
        }
        doneButtonSheet.setOnClickListener {
            sheetBottomDialog.dismiss()
        }
        val brandArray = resources.getStringArray(R.array.brand_array)
        val priceArray = resources.getStringArray(R.array.price_array)
        val sizeArray = resources.getStringArray(R.array.size_array)

        brandAutoComplete.setAdapter(
            ArrayAdapter(
                requireActivity(),
                R.layout.filter_bottom_text,
                brandArray
            )
        )
        priceAutoComplete.setAdapter(
            ArrayAdapter(
                requireActivity(),
                R.layout.filter_bottom_text,
                priceArray
            )
        )
        sizeAutoComplete.setAdapter(
            ArrayAdapter(
                requireActivity(),
                R.layout.filter_bottom_text,
                sizeArray
            )
        )

        binding.sortButton.setOnClickListener {
            sheetBottomDialog.show()
        }


    }

    private fun initCategoryRv() {
        val categoryRv = binding.recyclerViewCategory
        categoryAdapter = CategoryAdapter()
        categoryRv.adapter = categoryAdapter

        val homeRv = binding.hotSaleViewpager
        homeAdapter = HomeAdapter()
        homeRv.adapter = homeAdapter

        val bestSellerRv = binding.recyclerViewBestSeller
        bestSellerAdapter = BestSellerAdapter()
        bestSellerRv.adapter = bestSellerAdapter

        bestSellerAdapter.cardClickShow = object : BestSellerAdapter.CardClickListener {
            override fun cardClick() {
                findNavController().navigate(R.id.action_mainFragment_to_detailsFragment)
            }
        }


    }
}