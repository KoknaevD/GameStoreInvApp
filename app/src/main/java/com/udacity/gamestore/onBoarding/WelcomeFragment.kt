package com.udacity.gamestore.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.gamestore.R
import com.udacity.gamestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome, container, false
        )

        binding.nextButton.setOnClickListener {
            val action =
                WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }
        return binding.root
    }
}