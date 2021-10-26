package com.tjprojects.navigationdemo.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductObject(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
) : Parcelable