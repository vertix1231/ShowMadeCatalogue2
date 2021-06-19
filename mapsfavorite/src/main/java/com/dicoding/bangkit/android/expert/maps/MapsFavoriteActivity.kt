package com.dicoding.bangkit.android.expert.maps

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.bangkit.android.expert.core.ui.MadeCatalogueAdapter
import com.dicoding.bangkit.android.expert.maps.databinding.ActivityMapsFavoriteBinding
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class MapsFavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapsFavoriteBinding
    private val favoritemapsViewModel : FavoriteViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadKoinModules(favoriteModule)

        supportActionBar?.title = "Favorite Dynamic Feature MadeCatalogue"

//        getMadeCatalogueMapsData()

        val madeCatalogueAdapter = MadeCatalogueAdapter()
        madeCatalogueAdapter.onItemClick = {
            val intentfav = Intent(this, DetailActivity::class.java)
            intentfav.putExtra(DetailActivity.EXTRA_DATA,it)
            startActivity(intentfav)
        }
        favoritemapsViewModel.madecataluguefav.observe(this,{
            madeCatalogueAdapter.setData(it)
            binding.viewEmpty.root.visibility = if(it.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.recyclerViewGameRateFav){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = madeCatalogueAdapter
        }

//        loadKoinModules(mapsModule)
//
//        supportActionBar?.title = "Favorite MadeCatalogue Map"
//
//        getMadeCatalogueMapsData()
    }

//    @SuppressLint("SetTextI18n")
//    private fun getMadeCatalogueMapsData() {
//        mapsViewModel.madecataloguemap.observe(this,{
//            if (it!=null){
//                when(it){
//
//                    is Resource.Loading -> binding.progressBar.visibility= View.VISIBLE
//                    is Resource.Success -> {
//                        binding.progressBar.visibility = View.GONE
//                        binding.tvMaps.text = "This is map of ${it.data?.get(0)?.name}"
//                    }
//                    is Resource.Error -> {
//                        binding.progressBar.visibility = View.GONE
//                        binding.tvError.visibility = View.VISIBLE
//                        binding.tvError.text = it.message
//                    }
//                }
//            }
//        })
//    }
}