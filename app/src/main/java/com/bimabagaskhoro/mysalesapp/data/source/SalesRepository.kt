package com.bimabagaskhoro.mysalesapp.data.source

import android.util.Log
import com.bimabagaskhoro.mysalesapp.data.Resource
import com.bimabagaskhoro.mysalesapp.data.source.remote.RemoteDataSource
import com.bimabagaskhoro.mysalesapp.data.source.remote.network.ApiResponse
import com.bimabagaskhoro.mysalesapp.domain.model.ontask.ItemOntask
import com.bimabagaskhoro.mysalesapp.domain.model.task.ItemTask
import com.bimabagaskhoro.mysalesapp.domain.model.users.ItemUsers
import com.bimabagaskhoro.mysalesapp.domain.model.users.ItemUsersLogin
import com.bimabagaskhoro.mysalesapp.domain.repository.IItemSalesRepository
import com.bimabagaskhoro.mysalesapp.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SalesRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    IItemSalesRepository {

    private val TAG = SalesRepository::class.java.simpleName

    override fun getAllTask(): Flow<Resource<List<ItemTask>>> {
       return flow {
           when (val apiResponse = remoteDataSource.getAllTask().first()) {
               is ApiResponse.Success -> {
                   emit(Resource.Success(DataMapper.entitiesToDomain(apiResponse.data!!)))
               }
               is ApiResponse.Error -> {
                   emit(Resource.Error(apiResponse.errorMessage!!))
               }
               is ApiResponse.Empty -> {
                   Log.d(TAG, "getAllTask: Empty Data")
               }
           }
       }
    }

    override fun deleteTask(id: Int, method: String): Flow<Resource<String>> {
        return flow {
            emit(Resource.Loading(null))
            when(val apiResponse = remoteDataSource.deleteTask(id, method).first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(null, "success$id"))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "deleteTask: Empty Data")
                }
            }
        }
    }

    override fun getAllOnTask(): Flow<Resource<List<ItemOntask>>> {
        return flow {
            when (val apiResponse = remoteDataSource.getAllOnTask().first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(DataMapper.entitiesToDomainOnTask(apiResponse.data!!)))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "getAllOnTask: Empty Data")
                }
            }
        }
    }

    override fun insertOnTask(data: ItemOntask): Flow<Resource<String>> {
        val entity = DataMapper.domainToEntity(data)
        return flow {
            emit(Resource.Loading(null))
            when(val apiResponse = remoteDataSource.insertOnTask(entity).first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(null,"success"))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "insertOnTask: on task null")
                }
            }
        }
    }

    override fun registerUser(data: ItemUsers): Flow<Resource<String>> {
        val entity = DataMapper.domainToEntityRegister(data)
        return flow {
            emit(Resource.Loading(null))
            when(val apiResponse = remoteDataSource.register(entity).first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(null,"success"))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "registerUser: on task null")
                }
            }
        }
    }

    override fun loginUser(email: String, password: String): Flow<Resource<ItemUsersLogin>> {
        return flow {
            emit(Resource.Loading(null))
            when (val apiResponse = remoteDataSource.login(email, password).first()) {
                is ApiResponse.Success -> {
                    val data = DataMapper.entityToDomainLogin(apiResponse.data?.data!!)
                    emit(Resource.Success(data, apiResponse.data.message))
                }
                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage!!))
                }
                is ApiResponse.Empty -> {
                    Log.d(TAG, "login: login kosong")
                }
            }
        }
    }
}