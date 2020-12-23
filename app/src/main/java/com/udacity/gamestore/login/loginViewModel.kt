package com.udacity.gamestore.login

import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.gamestore.R

data class LoginFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)

data class LoginResult(
    val username: String = "",
    val hasLoggedIn: Boolean = false
)

class LoginViewModel() : ViewModel() {


    private var _username = ""
    private var _password = ""


    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult>
        get() = _loginResult


    private val _loginFormState = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState>
        get() = _loginFormState

    fun login() {
        _loginResult.value =
            LoginResult(_username, true)
    }

    fun onLoginFinishComplete() {
        _loginResult.value = LoginResult("", false)
    }

    fun usernameTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // ignore
            }

            override fun afterTextChanged(s: Editable) {
                _username = s.toString()
                loginDataChanged()
            }
        }
    }

    fun passwordTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // ignore
            }

            override fun afterTextChanged(s: Editable) {
                _password = s.toString()
                loginDataChanged()
            }
        }
    }

    fun loginDataChanged() {
        if (!isUserNameValid(_username)) {
            _loginFormState.value =
                LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(_password)) {
            _loginFormState.value =
                LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginFormState.value =
                LoginFormState(isDataValid = true)
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