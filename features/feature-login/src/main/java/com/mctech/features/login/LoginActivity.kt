package com.mctech.features.login

import android.os.Bundle
import com.mctech.feature.arq.BaseActivity
import com.mctech.feature.arq.extentions.bindData
import com.mctech.features.login.state.LoginState
import com.mctech.features.navigation.Screen
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<LoginViewModel>() {
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bindData(loginViewModel.loginSreenState) {
            when (it) {
                is LoginState.Authenticated -> navigator.navigateTo(
                    destination = Screen.Dashboard,
                    finishHost = true
                )
            }
        }
    }
}
