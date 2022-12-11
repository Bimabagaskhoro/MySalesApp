package com.bimabagaskhoro.mysalesapp.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bimabagaskhoro.mysalesapp.domain.model.ontask.ItemOntask
import com.bimabagaskhoro.mysalesapp.domain.usecase.ItemSalesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnTaskSuccessViewModel @Inject constructor(val useCase: ItemSalesUseCase) : ViewModel() {
    fun getAllOnTask() = useCase.getAllOnTask().asLiveData()
    fun postOnTask(data: ItemOntask) = useCase.insertOnTask(data).asLiveData()
}