package com.udacity.gamestore.login.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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


        viewModel.eventLoginFinish.observe(viewLifecycleOwner, Observer { hasLoggedIn ->
            if (hasLoggedIn) {
                loginFinished()
                viewModel.onLoginComplete()
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

        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // ignore
            }

            override fun afterTextChanged(s: Editable) {
                viewModel.loginDataChanged()
            }
        }
        binding.username.addTextChangedListener(afterTextChangedListener)
        binding.password.addTextChangedListener(afterTextChangedListener)

        return binding.root
    }


    private fun loginFinished() {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, "welcome ${viewModel.username}", Toast.LENGTH_LONG).show()
    }

}