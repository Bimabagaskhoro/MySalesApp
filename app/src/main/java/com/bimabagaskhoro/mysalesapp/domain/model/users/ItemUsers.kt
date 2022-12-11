package com.bimabagaskhoro.mysalesapp.domain.model.users

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemUsers(
    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("password")
    val password: String,

    @field:SerializedName("name")
    val name: String
): Parcelable

@Parcelize
data class ItemUsersLogin(
    @field:SerializedName("token")
    val token: String
): Parcelable
