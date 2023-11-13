package com.oechslerbernardo.teste.presentation.login

data class LoginState(
    val isLoggedin: Boolean = false,
    val isLoginClick: Boolean = false,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isError: String? = null,
)