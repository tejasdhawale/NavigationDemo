package com.tjprojects.navigationdemo.productList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tjprojects.navigationdemo.R
import com.tjprojects.navigationdemo.base.getViewModel
import com.tjprojects.navigationdemo.databinding.ProductListFragmentBinding

class ProductListFragment : Fragment() {
    lateinit var navController: NavController
    lateinit var mBinding: ProductListFragmentBinding
    private lateinit var viewModel: ProductListViewModel
    private val TAG = ProductListFragment::class.java.name


    companion object {
        fun newInstance() = ProductListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        Log.e(TAG, "navController initialized ")
        mBinding.selectProduct.setOnClickListener { navController.navigate(R.id.action_productListFragment_to_productInfoFragment) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pModel = ProductListFragmentArgs.fromBundle(requireArguments()).productModel

        viewModel = getViewModel { ProductListViewModel(pModel) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.product_list_fragment, container, false)
        mBinding.vm = viewModel
        mBinding.lifecycleOwner = viewLifecycleOwner



        return mBinding.root

    }

}