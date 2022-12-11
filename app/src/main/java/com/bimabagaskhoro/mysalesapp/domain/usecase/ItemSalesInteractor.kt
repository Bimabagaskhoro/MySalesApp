package com.bimabagaskhoro.mysalesapp.domain.usecase

import com.bimabagaskhoro.mysalesapp.data.Resource
import com.bimabagaskhoro.mysalesapp.domain.model.ontask.ItemOntask
import com.bimabagaskhoro.mysalesapp.domain.model.task.ItemTask
import com.bimabagaskhoro.mysalesapp.domain.model.users.ItemUsers
import com.bimabagaskhoro.mysalesapp.domain.model.users.ItemUsersLogin
import com.bimabagaskhoro.mysalesapp.domain.repository.IItemSalesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemSalesInteractor @Inject constructor(private val itemTaskRepository: IItemSalesRepository) :
    ItemSalesUseCase {
    override fun getAllTask(): Flow<Resource<List<ItemTask>>> =
        itemTaskRepository.getAllTask()

    override fun deleteTask(id: Int, method :String): Flow<Resource<String>> =
        itemTaskRepository.deleteTask(id, method)

    override fun getAllOnTask(): Flow<Resource<List<ItemOntask>>> =
        itemTaskRepository.getAllOnTask()

    override fun insertOnTask(data: ItemOntask): Flow<Resource<String>> =
        itemTaskRepository.insertOnTask(data)

    override fun registerUser(data: ItemUsers): Flow<Resource<String>> =
        itemTaskRepository.registerUser(data)

    override fun loginUser(email:String, password: String): Flow<Resource<ItemUsersLogin>> =
        itemTaskRepository.loginUser(email, password)

}