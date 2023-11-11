package com.oechslerbernardo.teste.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    viewModel:LoginViewModel,
    onLoginClick: () -> Unit,
    onSignupClick: () -> Unit
) {

    LaunchedEffect(key1 = true) {
        viewModel.loginEvent.collect { event ->
            when (event) {
                is LoginEvent.OnLoginClick -> {
                    onLoginClick()
                }

                is LoginEvent.OnSignupClick -> {
                    onSignupClick()
                }

                else -> {}
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            viewModel.onEvent(LoginEvent.OnLoginClick)
        }) {
            Text(text = "Login")
        }
        Button(
            modifier = Modifier.padding(40.dp),
            onClick = {
                viewModel.onEvent(LoginEvent.OnSignupClick)
            }) {
            Text(text = "Sign up")
        }
    }
}