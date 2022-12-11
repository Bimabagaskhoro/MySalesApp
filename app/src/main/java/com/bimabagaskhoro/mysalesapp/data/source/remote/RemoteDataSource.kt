package com.bimabagaskhoro.mysalesapp.data.source.remote

import android.util.Log
import com.bimabagaskhoro.mysalesapp.data.source.remote.network.ApiResponse
import com.bimabagaskhoro.mysalesapp.data.source.remote.network.ApiService
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.ResponseTaskSuccess
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.onTask.DataItemOnTask
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.task.DataItem
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.users.DataItemUsers
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.users.ResponseLogin
import com.bimabagaskhoro.mysalesapp.data.source.remote.response.users.ResponseRegister
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    private val TAG = RemoteDataSource::class.java.simpleName

    suspend fun getAllTask(): Flow<ApiResponse<List<DataItem>>> {
        return flow {
            try {
                val response = apiService.getAllTask()
                val data = response.data
                if (response.status == 200) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.d(TAG, "getAllTask: ${e.message}")
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun deleteTask(id: Int, method: String): Flow<ApiResponse<ResponseTaskSuccess>> {
        return flow {
            val response = apiService.deleteTask(id, method)
            when(response.status) {
                200 -> emit(ApiResponse.Success(response))
                404 -> emit(ApiResponse.Error("failed"))
                else -> emit(ApiResponse.Empty)
            }
        }
    }

    suspend fun insertOnTask(data: DataItemOnTask): Flow<ApiResponse<ResponseTaskSuccess>> {
        return flow {
            val queries     = HashMap<String, String>()
            queries["name"] = data.name
            queries["location"] = data.location
            queries["capture"] = data.capture
            queries["status"] = data.status

            val response = apiService.insertOnTask(queries)
            when (response.status) {
                200 -> emit(ApiResponse.Success(response))
                404 -> emit(ApiResponse.Error("failed"))
                else -> emit(ApiResponse.Empty)
            }
        }
    }

    suspend fun getAllOnTask(): Flow<ApiResponse<List<DataItemOnTask>>> {
        return flow {
            try {
                val response = apiService.getAllOnTask()
                val data = response.data
                if (response.status == 200) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.d(TAG, "getAllTask: ${e.message}")
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun login(email: String, password: String): Flow<ApiResponse<ResponseLogin>> {
        return flow {
            val response = apiService.login(email, password)
            when (response.status) {
                200 -> emit(ApiResponse.Success(response))
            }
        }
    }

    suspend fun register(data: DataItemUsers): Flow<ApiResponse<ResponseRegister>> {
        return flow {
            val queries     = HashMap<String, String>()
            queries["name"] = data.name
            queries["email"] = data.email
            queries["password"] = data.password

            val response = apiService.register(queries)
            when (response.status) {
                200 -> emit(ApiResponse.Success(response))
                404 -> emit(ApiResponse.Error("failed"))
                else -> emit(ApiResponse.Empty)
            }
        }
    }
}