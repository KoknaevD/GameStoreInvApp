package com.udacity.gamestore.login.data

import android.util.Patterns
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.gamestore.R

data class LoginFormState(val usernameError: Int? = null,
                          val passwordError: Int? = null,
                          val isDataValid: Boolean = false)

class LoginViewModel : ViewModel() {


    var username = ObservableField<String>()
    var password = ObservableField<String>()

                                                                          

    private val _loginFormState = MutableLiveData<LoginFormState>()
    val loginFormState : LiveData<LoginFormState>
        get() = _loginFormState

    private val _eventLoginFinish = MutableLiveData<Boolean>()
    val eventLoginFinish : LiveData<Boolean>
        get() = _eventLoginFinish

    fun login(){
        _eventLoginFinish.value = true
    }

    fun onLoginComplete() {
        _eventLoginFinish.value = false
    }

    fun loginDataChanged() {
        val mUser: String = username.get() ?: ""
        val mPass: String = password.get() ?: ""

        if (!isUserNameValid(mUser)) {
            _loginFormState.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(mPass)) {
            _loginFormState.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginFormState.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains("@")) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}