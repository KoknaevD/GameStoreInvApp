package com.udacity.gamestore.games


import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.udacity.gamestore.R
import com.udacity.gamestore.databinding.CardGameBinding
import com.udacity.gamestore.databinding.FragmentGamesListBinding


class GamesListFragment : Fragment() {
    private lateinit var binding: FragmentGamesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_games_list, container, false
        )

        //viewModel = ViewModelProvider(this).get(GamesViewModel::class.java)
        //Redesigned for LinearLayout
        val viewModel: GamesViewModel by activityViewModels()
        viewModel.games.observe(viewLifecycleOwner, Observer { games ->

            for (game in games) {
                val layBinding = DataBindingUtil.inflate<CardGameBinding>(
                    LayoutInflater.from(context),
                    R.layout.card_game,
                    container,
                    false
                )
                layBinding.game = game
                binding.gameList.addView(layBinding.root)
            }

        })

        binding.fab.setOnClickListener {
            val action = GamesListFragmentDirections.actionGameListFragmentToGameDetailFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)

    }
}