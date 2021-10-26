package com.tjprojects.navigationdemo.productList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tjprojects.navigationdemo.models.ProductObject

class ProductListViewModel(pModel: ProductObject) : ViewModel() {
    var typeName = MutableLiveData<String>(pModel.name)
}