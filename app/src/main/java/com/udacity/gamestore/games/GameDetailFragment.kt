package com.udacity.gamestore.games

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.gamestore.R
import com.udacity.gamestore.databinding.FragmentGameDetailBinding


class GameDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentGameDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_game_detail, container, false
        )


        binding.button.setOnClickListener {
            val viewModel: GamesViewModel by activityViewModels()
            viewModel.addNewGame("test_name", 1337.00, "test_company", "test_description")
            this.findNavController().popBackStack()
        }

        return binding.root
    }
}