package com.udacity.gamestore.games


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.gamestore.R
import com.udacity.gamestore.databinding.FragmentGamesListBinding

class GamesListFragment : Fragment() {
    private lateinit var viewModel: GamesViewModel
    private lateinit var binding: FragmentGamesListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_games_list, container, false
        )

        viewModel = ViewModelProvider(this).get(GamesViewModel::class.java)
        viewModel.games.observe(viewLifecycleOwner, Observer { games ->
           binding.gameRecycler.also {
               it.adapter = GamesAdapter(games)
               it.layoutManager = LinearLayoutManager(requireContext())
               it.setHasFixedSize(true)
           }
        })

        return binding.root
    }

 }