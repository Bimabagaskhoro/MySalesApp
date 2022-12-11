package com.bimabagaskhoro.mysalesapp.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseTaskSuccess(
	val message: String,
	val status: Int
) : Parcelable
