package com.bimabagaskhoro.mysalesapp.data.source.remote.network

import com.bimabagaskhoro.mysalesapp.data.source.remote.response.ResponseTaskSuccess
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.onTask.ResponseGetOnTaskSuccess
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.task.ResponseGetTask
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.users.ResponseLogin
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.users.ResponseRegister
import retrofit2.http.*

interface ApiService {
    @GET("task")
    suspend fun getAllTask(): ResponseGetTask

    @FormUrlEncoded
    @POST("task")
    suspend fun deleteTask(
        @Field("id") id: Int,
        @Field("_method") method: String
    ): ResponseTaskSuccess

    @FormUrlEncoded
    @POST("ontasksuccess")
    suspend fun insertOnTask(
        @FieldMap parameters: HashMap<String, String>
    ): ResponseTaskSuccess

    @GET("ontasksuccess")
    suspend fun getAllOnTask(): ResponseGetOnTaskSuccess

    @FormUrlEncoded
    @POST("api/login")
    suspend fun login (
        @Field("email") id: String,
        @Field("password") password: String
    ): ResponseLogin

    @FormUrlEncoded
    @POST("api/register")
    suspend fun register (
        @FieldMap parameters: HashMap<String, String>
    ): ResponseRegister
}