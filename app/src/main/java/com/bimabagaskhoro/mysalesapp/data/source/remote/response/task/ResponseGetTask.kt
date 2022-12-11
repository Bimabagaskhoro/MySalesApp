package com.bimabagaskhoro.mysalesapp.data.source.remote.response.task

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseGetTask(
	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("status")
	val status: Int
) : Parcelable

@Parcelize
data class DataItem(
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
