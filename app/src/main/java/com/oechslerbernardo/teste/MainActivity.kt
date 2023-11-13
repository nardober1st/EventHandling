package com.oechslerbernardo.teste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oechslerbernardo.teste.presentation.Route
import com.oechslerbernardo.teste.presentation.home.HomeScreen
import com.oechslerbernardo.teste.presentation.login.LoginScreen
import com.oechslerbernardo.teste.presentation.login.LoginViewModel
import com.oechslerbernardo.teste.presentation.signup.SignupScreen
import com.oechslerbernardo.teste.ui.theme.TesteTheme

class MainActivity : ComponentActivity() {

    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            TesteTheme {
                NavHost(
                    navController = navController,
                    startDestination = Route.LOGIN
                ) {
                    composable(Route.LOGIN) {
                        LoginScreen(
                            viewModel = loginViewModel,
                            onLoginClick = { navController.navigate(Route.HOME) },
                            onSignupClick = { navController.navigate(Route.SINGUP) }
                        )
                    }
                    composable(Route.SINGUP) {
                        SignupScreen()
                    }
                    composable(Route.HOME) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}
