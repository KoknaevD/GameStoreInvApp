package com.udacity.gamestore.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.gamestore.ActivityViewModel
import com.udacity.gamestore.R
import com.udacity.gamestore.databinding.FragmentLoginBinding
import com.udacity.gamestore.login.data.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this


        viewModel.loginResult.observe(viewLifecycleOwner, Observer { loginResult ->
            if (loginResult.hasLoggedIn) {
                loginFinished(loginResult.username)
                viewModel.onLoginFinishComplete()
            }
        })

        viewModel.loginFormState.observe(viewLifecycleOwner,
            Observer { loginFormState ->
                if (loginFormState == null) {
                    return@Observer
                }
                binding.login.isEnabled = loginFormState.isDataValid
                loginFormState.usernameError?.let {
                    binding.username.error = getString(it)
                }
                loginFormState.passwordError?.let {
                    binding.password.error = getString(it)
                }
            })

        return binding.root
    }


    private fun loginFinished(username: String) {
        val model: ActivityViewModel by activityViewModels()
        model.login(username)
    }

}