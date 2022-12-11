package com.bimabagaskhoro.mysalesapp.domain.usecase

import com.bimabagaskhoro.mysalesapp.data.Resource
import com.bimabagaskhoro.mysalesapp.domain.model.ontask.ItemOntask
import com.bimabagaskhoro.mysalesapp.domain.model.task.ItemTask
import com.bimabagaskhoro.mysalesapp.domain.model.users.ItemUsers
import com.bimabagaskhoro.mysalesapp.domain.model.users.ItemUsersLogin
import kotlinx.coroutines.flow.Flow

interface ItemSalesUseCase {
    fun getAllTask(): Flow<Resource<List<ItemTask>>>
    fun deleteTask(id: Int, method :String): Flow<Resource<String>>

    fun getAllOnTask(): Flow<Resource<List<ItemOntask>>>
    fun insertOnTask(data: ItemOntask): Flow<Resource<String>>

    fun registerUser(data: ItemUsers): Flow<Resource<String>>
    fun loginUser(email: String, password: String): Flow<Resource<ItemUsersLogin>>
}