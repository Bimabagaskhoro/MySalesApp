package com.bimabagaskhoro.mysalesapp.data.source.remote.response.users

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseRegister(
	val message: String,
	val status: Int
) : Parcelable

@Parcelize
data class DataItemUsers(
	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("name")
	val name: String
) : Parcelable
