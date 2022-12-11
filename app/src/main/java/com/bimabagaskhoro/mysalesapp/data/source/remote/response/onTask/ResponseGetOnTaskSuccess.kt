package com.bimabagaskhoro.mysalesapp.data.source.remote.response.onTask

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseGetOnTaskSuccess(
	@field:SerializedName("data")
	val data: List<DataItemOnTask>,

	@field:SerializedName("status")
	val status: Int
) : Parcelable

@Parcelize
data class DataItemOnTask(
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
) : Parcelable
