package com.oechslerbernardo.teste.presentation.login

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/*
@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onLoginClick: () -> Unit,
    onSignupClick: () -> Unit
) {

    val context = LocalContext.current

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

        LaunchedEffect(key1 = true) {
            viewModel.loginEventChannel.collect { event ->
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

        // Additional UI components based on loginState
        when {
            viewModel.loginState.isLoading -> {
                // Display a loading indicator
                CircularProgressIndicator(modifier = Modifier.wrapContentSize())
            }
            viewModel.loginState.isError != null -> {
                // Handle login error
                // You can also include a UI element to display the error
                Toast.makeText(context, "Error: ${viewModel.loginState.isError}", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}
*/

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onLoginClick: () -> Unit,
    onSignupClick: () -> Unit
) {

    val state = viewModel.loginState
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            viewModel.onLoginClick()
        }) {
            Text(text = "Login")
        }
        Button(
            modifier = Modifier.padding(40.dp),
            onClick = {
                viewModel.onSignupClick()
            }) {
            Text(text = "Sign up")
        }

        // Additional UI components based on loginState
        when  {
            state.isLoading-> {
                // Display a loading indicator
                CircularProgressIndicator(modifier = Modifier.wrapContentSize())
            }
            state.isSuccess -> {
                if (state.isLoginClick) {
                    onLoginClick()
                } else {
                    onSignupClick()
                }
            }
            state.isError != null -> {
                // Handle login error
                // You can also include a UI element to display the error
                Toast.makeText(context, "Error: ${state.isError}", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}