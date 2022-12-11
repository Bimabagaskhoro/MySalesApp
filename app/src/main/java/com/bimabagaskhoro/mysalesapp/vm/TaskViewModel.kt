package com.bimabagaskhoro.mysalesapp.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bimabagaskhoro.mysalesapp.domain.usecase.ItemSalesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(val useCase: ItemSalesUseCase) : ViewModel() {
    fun getAllTask() = useCase.getAllTask().asLiveData()
    fun deleteTask(id: Int, method :String) = useCase.deleteTask(id, method).asLiveData()
}