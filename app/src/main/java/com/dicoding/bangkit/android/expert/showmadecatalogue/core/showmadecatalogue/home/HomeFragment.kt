package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.bangkit.android.expert.core.data.Resource
import com.dicoding.bangkit.android.expert.core.ui.MadeCatalogueAdapter
import com.dicoding.bangkit.android.expert.showmadecatalogue.R
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.detail.DetailActivity
import com.dicoding.bangkit.android.expert.showmadecatalogue.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
//    private lateinit var homeViewModel: HomeViewModel
    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val madeCatalogueAdapter = MadeCatalogueAdapter()
            madeCatalogueAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

//            val factory = ViewModelFactory.getInstance(requireActivity())
//            homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

            homeViewModel.madeCatalogue.observe(viewLifecycleOwner,{
                if (it!=null){
                    when(it){
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            madeCatalogueAdapter.setData(it.data)

                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = it.message ?: getString(R.string.something_wrong)

                        }

                    }
                }
            })

            with(binding.rvTourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = madeCatalogueAdapter

            }
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}