package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.bangkit.android.expert.core.ui.MadeCatalogueAdapter
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.detail.DetailActivity
import com.dicoding.bangkit.android.expert.showmadecatalogue.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
//    private lateinit var favoriteViewModel: FavoriteViewModel

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val madecatalogueAdapter = MadeCatalogueAdapter()
            madecatalogueAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

//            val factory = ViewModelFactory.getInstance(requireActivity())
//            favoriteViewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            favoriteViewModel.favoriteMadeCatalogue.observe(viewLifecycleOwner,{
                madecatalogueAdapter.setData(it)
                binding.viewEmpty.root.visibility = if (it.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvTourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = madecatalogueAdapter

            }
        }


    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}