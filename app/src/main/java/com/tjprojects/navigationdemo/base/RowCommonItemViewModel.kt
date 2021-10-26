package com.tjprojects.navigationdemo.base

import android.view.View
import androidx.databinding.ObservableField
import com.tjprojects.navigationdemo.models.ProductObject

class RowCommonItemViewModel(
    private val item: ProductObject,
    private val listener: CommonItemClickListener
) {

    val title = ObservableField<String>()

    init {
        this.title.set(item.name)
    }

    fun onItemClick(view: View) {
        listener.onItemClick(item)
    }

}