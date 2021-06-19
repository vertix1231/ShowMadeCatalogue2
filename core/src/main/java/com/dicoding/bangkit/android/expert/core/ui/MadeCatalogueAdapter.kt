package com.dicoding.bangkit.android.expert.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.bangkit.android.expert.core.R
import com.dicoding.bangkit.android.expert.core.databinding.ItemRowDataBinding
import com.dicoding.bangkit.android.expert.core.domain.model.MadeCatalogue
import java.util.*

class MadeCatalogueAdapter : RecyclerView.Adapter<MadeCatalogueAdapter.ListViewHolder>(){
    private var listData = ArrayList<MadeCatalogue>()
    var onItemClick: ((MadeCatalogue) -> Unit)? = null

    fun setData(newListData: List<MadeCatalogue>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowDataBinding.bind(itemView)

        fun bind(data: MadeCatalogue) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(ivItemImage)
                tvItemTitle.text = data.name
                tvItemSubtitle.text = data.rating
            }
        }
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_data,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}