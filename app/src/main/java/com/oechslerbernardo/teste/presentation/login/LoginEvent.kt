package com.oechslerbernardo.teste.presentation.login

sealed class LoginEvent {
    object OnLoginClick: LoginEvent()
    object OnSignupClick: LoginEvent()
}
