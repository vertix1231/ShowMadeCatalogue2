package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.bangkit.android.expert.core.domain.model.MadeCatalogue
import com.dicoding.bangkit.android.expert.showmadecatalogue.R
import com.dicoding.bangkit.android.expert.showmadecatalogue.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailViewModel: DetailViewModel by viewModel()
//    private lateinit var detailViewModel: DetailViewModel
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)

//        val factory = ViewModelFactory.getInstance(this)
//        detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val madeCatalogue = intent.getParcelableExtra<MadeCatalogue>(EXTRA_DATA)
        showDetailTourism(madeCatalogue)
    }

    private fun showDetailTourism(madeCatalogue: MadeCatalogue?) {
        madeCatalogue?.let {
            supportActionBar?.title = madeCatalogue.name
            binding.content.tvDetailDescription.text = "Deskirpsi singkat item entertaiment ${madeCatalogue.name}: \n \n" +
                    " ${madeCatalogue.name} merupakan item entertaiment dengan id ${madeCatalogue.Id} yang di rilis pada tahun ${madeCatalogue.released} dengan " +
                    "rating ${madeCatalogue.rating} telah dimainkan total pengguna seluruh dunia dengan total waktu" +
                    " ${madeCatalogue.playtime}. Pengguna yang telah memakai atau memainkan item entertaiment ini juga didapat" +
                    "data yang menunjukkan ada total rating count dari pengguna sebagai penilaian produk dengan total" +
                    " ${madeCatalogue.ratings_count}. Metacritic.com merupakan situs web yang memberi pendapat tentang " +
                    "album, video game, film, acara televisi dan DVD telah memberi penialaian terhadap item ini dengan nilai" +
                    " ${madeCatalogue.metacritic} dan telah diverifikasi juga penilaian" +
                    "secara resmi. ${madeCatalogue.name} sangat direkomendasikan untuk menghilangkan permasalahan dunia" +
                    "dan relax sebentar menikmati layanan entertaiment ini terutama bersama" +
                    "teman dan keluarga :)"
//            binding.content.tvDetailDescription.text = madeCatalogue.name
            Glide.with(this@DetailActivity)
                .load(madeCatalogue.image)
                .into(binding.ivDetailImage)

            var statusFavorite = madeCatalogue.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavorite(madeCatalogue, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}