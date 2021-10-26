package com.tjprojects.navigationdemo.landingpage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tjprojects.navigationdemo.R
import com.tjprojects.navigationdemo.base.CommonItemClickListener
import com.tjprojects.navigationdemo.base.RowCommonItemViewModel
import com.tjprojects.navigationdemo.databinding.LandingPageFragmentBinding
import com.tjprojects.navigationdemo.databinding.RowProductTypeViewBinding
import com.tjprojects.navigationdemo.models.ProductObject

class LandingPageFragment : Fragment(), CommonItemClickListener {

    lateinit var navController: NavController
    lateinit var mBinding: LandingPageFragmentBinding
    private lateinit var viewModel: LandingPageViewModel
    private lateinit var itemClickListener: CommonItemClickListener

    companion object {
        fun newInstance() = LandingPageFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemClickListener = this
        viewModel = ViewModelProvider(this).get(LandingPageViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.landing_page_fragment, container, false)
        mBinding.vm = viewModel
        mBinding.lifecycleOwner = viewLifecycleOwner


        getProductTypeList()

        /** Not sending any data here */
        mBinding.favProduct.setOnClickListener { navController.navigate(R.id.action_landingPageFragment_to_favoriteProductsFragment) }

        return mBinding.root

    }

    private fun getProductTypeList() {
        viewModel.typeList.let { pList ->
            if (pList.isEmpty()) {
                val layoutInflater =
                    activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                getDummyList().forEach {
                    it.let { item ->
                        val subServiceViewBinding =
                            DataBindingUtil.inflate<RowProductTypeViewBinding>(
                                layoutInflater,
                                R.layout.row_product_type_view, null, false
                            )
                        val pointItemVm = RowCommonItemViewModel(item, itemClickListener)
                        subServiceViewBinding.vm = pointItemVm
                        viewModel.typeList.add(subServiceViewBinding.root)
                    }
                }
            }
        }
    }


    private fun getDummyList(): List<ProductObject> {
        val pointsList = ArrayList<ProductObject>()
        pointsList.add(ProductObject(1, "Dairy"))
        pointsList.add(ProductObject(2, "Baby Product"))
        pointsList.add(ProductObject(3, "Energy Drinks"))
        pointsList.add(ProductObject(4, "Cookies"))
        return pointsList
    }

    override fun onItemClick(pModel: ProductObject) {

        /** Data passing
         *  sending custom model to
         *  product list  fragment **/
        val action =
            LandingPageFragmentDirections.actionLandingPageFragmentToProductListFragment(pModel)
        navController.navigate(action)

    }
}


