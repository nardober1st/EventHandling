package com.oechslerbernardo.teste.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {

//    private val _loginEvent = MutableSharedFlow<LoginEvent>()
//    val loginEvent: SharedFlow<LoginEvent> = _loginEvent
//    val loginEvent = _loginEvent.asSharedFlow()

    private val _loginEvenChannel = Channel<LoginEvent>()
    val loginEventChannel = _loginEvenChannel.receiveAsFlow()

    //    var isLoginClick by mutableStateOf(false)
//        private set
//    var loginState by mutableStateOf(LoginState())
//        private set

    var loginState by mutableStateOf(LoginState())
        private set

    //    fun onEvent(event: LoginEvent) {
//        viewModelScope.launch {
//            when (event) {
//                is LoginEvent.OnLoginClick -> {
//                    loginState.value =
//                        LoginState(isLoginClick = true, isLoading = false, isSuccess = true)
//                    _loginEvent.emit(LoginEvent.OnLoginClick)
//                }
//
//                is LoginEvent.OnSignupClick -> {
//                    loginState.value =
//                        LoginState(isLoginClick = false, isLoading = false, isSuccess = true)
//                    _loginEvent.emit(LoginEvent.OnSignupClick)
//                }
//
//                else -> {}
//            }
//        }
//    }
//    fun onEvent(event: LoginEvent) {
//        when (event) {
//            is LoginEvent.OnLoginClick -> {
//                loginState = loginState.copy(
////                    isLoginClick = true,
//                    isLoading = false,
//                    isSuccess = true
//                )
//                viewModelScope.launch {
//                    _loginEvent.emit(LoginEvent.OnLoginClick)
//                }
//            }
//
//            is LoginEvent.OnSignupClick -> {
//                loginState = loginState.copy(
////                    isLoginClick = true,
//                    isLoading = false,
//                    isSuccess = true
//                )
//                viewModelScope.launch {
//                    _loginEvent.emit(LoginEvent.OnSignupClick)
//                }
//            }
//
//            else -> {}
//        }
//    }
//
    // 1st WAY

    /*
     fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnLoginClick -> {
                loginState = loginState.copy(
                    isLoading = true
                )
                viewModelScope.launch {
                    try {
                        // Simulate a network request delay
                        delay(1000)

                        loginState = loginState.copy(
//                            isLoginClick = true,
                            isLoading = false,
                            isSuccess = true
                        )
                        _loginEvenChannel.send(LoginEvent.OnLoginClick)
                    } catch (e: Exception) {
                        val errorMessage = "Login failed: ${e.message}"
                        loginState = loginState.copy(
                            isError = errorMessage
                        )
                    }
                }
            }

            is LoginEvent.OnSignupClick -> {
                loginState = loginState.copy(
                    isLoading = true
                )
                viewModelScope.launch {
                    try {
                        // Simulate a network request delay
                        delay(1000)

                        // Simulate successful signup
                        loginState = loginState.copy(
//                            isLoginClick = false,
                            isLoading = false,
                            isSuccess = true
                        )
                        _loginEvenChannel.send(LoginEvent.OnSignupClick)
                    } catch (e: Exception) {
                        val errorMessage = "Signup failed: ${e.message}"
                        loginState = loginState.copy(
                            isLoading = false,
                            isError = errorMessage
                        )
                    }
                }
            }

            else -> {}
        }
    }
     */

    // 2nd WAY

//    fun onEvent(event: LoginEvent) {
//        when (event) {
//            is LoginEvent.OnLoginClick -> {
//                viewModelScope.launch { handleLogin() }
//            }
//
//            is LoginEvent.OnSignupClick -> {
//                viewModelScope.launch { handleSingup() }
//            }
//        }
//    }

    fun onNavigatedToLogin() {
        loginState = loginState.copy(isLoggedin = false)
    }
    fun onLoginClickBack() {
        loginState = loginState.copy(isLoginClick = false)
    }

    fun onLoginClick() {
        loginState = loginState.copy(isLoading = true)
        viewModelScope.launch {
            try {
                delay(1000)
                loginState =
                    loginState.copy(isLoading = false, isSuccess = true, isLoginClick = true, isLoggedin = true)
            } catch (e: Exception) {
                loginState =
                    loginState.copy(isLoading = false, isError = "Login failed!")
            }
        }
    }

    fun onSignupClick() {
        loginState = loginState.copy(isLoading = true)
        viewModelScope.launch {
            try {
                delay(1000)
                loginState =
                    loginState.copy(isLoading = false, isSuccess = true, isLoginClick = false, isLoggedin = true)
            } catch (e: Exception) {
                loginState =
                    loginState.copy(isLoading = false, isError = "Unkown error!")
            }
        }
    }
}