package com.bimabagaskhoro.mysalesapp.domain.model.task

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Parcelize
data class ItemTask(
    @field:SerializedName("level")
    val level: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("location")
    val location: String,

    @field:SerializedName("status")
    val status: String
) : Parcelable
