package com.bimabagaskhoro.mysalesapp.domain.model.ontask

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemOntask(
    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("capture")
    val capture: String,

    @field:SerializedName("location")
    val location: String,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("status")
    val status: String
): Parcelable
