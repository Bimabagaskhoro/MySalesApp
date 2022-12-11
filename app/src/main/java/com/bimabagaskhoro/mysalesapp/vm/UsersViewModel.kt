package com.bimabagaskhoro.mysalesapp.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bimabagaskhoro.mysalesapp.domain.model.users.ItemUsers
import com.bimabagaskhoro.mysalesapp.domain.usecase.ItemSalesUseCase
import com.bimabagaskhoro.mysalesapp.sf.AppSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(val useCase: ItemSalesUseCase, val sharedPreferences: AppSharedPreferences) : ViewModel() {
    fun postOnTask(data: ItemUsers) = useCase.registerUser(data).asLiveData()
    fun login(email: String, password: String) = useCase.loginUser(email, password).asLiveData()

    private var _loginSession = sharedPreferences
    val loginSession get() = _loginSession.loginSession

    private var _userToken = sharedPreferences

    val userToken get() = _userToken.userToken

    fun setSession(session: Boolean) {
        _loginSession.loginSession = session
    }

    fun logoutUser() = _userToken.logouts

    fun setUserToken(userToken: String) {
        _userToken.userToken = userToken
    }
}