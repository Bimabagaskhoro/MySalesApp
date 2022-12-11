package com.bimabagaskhoro.mysalesapp.data.source.remote.response.users

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseLogin(
	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
) : Parcelable

@Parcelize
data class Data(
	@field:SerializedName("token")
	val token: String
) : Parcelable
