package com.tjprojects.navigationdemo.productInfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tjprojects.navigationdemo.R
import com.tjprojects.navigationdemo.databinding.ProductInfoFragmentBinding


class ProductInfoFragment : Fragment() {


    private lateinit var viewModel: ProductInfoViewModel
    lateinit var navController: NavController
    lateinit var mBinding: ProductInfoFragmentBinding
    private val TAG = ProductInfoFragment::class.java.name


    companion object {
        fun newInstance() = ProductInfoFragment()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        mBinding.addToFav.setOnClickListener {
            Toast.makeText(activity, "add to Fav", Toast.LENGTH_LONG).show()
        }

        mBinding.goHome.setOnClickListener {
            navController.navigate(R.id.action_productInfoFragment_to_landingPageFragment)
        }

        Log.e(TAG, "navController initialized ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductInfoViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.product_info_fragment, container, false)
        mBinding.vm = viewModel
        mBinding.lifecycleOwner = viewLifecycleOwner



        return mBinding.root
    }


}