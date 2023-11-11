package com.oechslerbernardo.teste.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class LoginViewModel(): ViewModel() {

//    private val _loginEvent = Channel<LoginEvent>()
//    val loginEvent: Flow<LoginEvent> = _loginEvent.receiveAsFlow()

    private val _loginEvent = MutableSharedFlow<LoginEvent>()
    val loginEvent: SharedFlow<LoginEvent> = _loginEvent

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnLoginClick -> {
                viewModelScope.launch {
                    _loginEvent.emit(LoginEvent.OnLoginClick)
                }
            }
            is LoginEvent.OnSignupClick -> {
                viewModelScope.launch {
                    _loginEvent.emit(LoginEvent.OnSignupClick)
                }
            }

            else -> {}
        }
    }
}