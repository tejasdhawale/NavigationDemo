package com.tjprojects.navigationdemo.favorites

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tjprojects.navigationdemo.R
import com.tjprojects.navigationdemo.databinding.FavoriteProductsFragmentBinding
import com.tjprojects.navigationdemo.productInfo.ProductInfoFragment

class FavoriteProductsFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteProductsFragment()
    }

    lateinit var navController: NavController
    lateinit var mBinding: FavoriteProductsFragmentBinding

    private lateinit var viewModel: FavoriteProductsViewModel

    private val TAG = FavoriteProductsFragment::class.java.name

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavoriteProductsViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        mBinding.selectProduct.setOnClickListener { navController.navigate(R.id.action_favoriteProductsFragment_to_productInfoFragment) }


        Log.e(TAG, "navController initialized ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavoriteProductsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.favorite_products_fragment, container, false)
        mBinding.vm = viewModel
        mBinding.lifecycleOwner = viewLifecycleOwner



        return mBinding.root
    }

}