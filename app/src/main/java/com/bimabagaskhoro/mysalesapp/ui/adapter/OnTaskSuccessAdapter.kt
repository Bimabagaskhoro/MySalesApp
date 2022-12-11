package com.bimabagaskhoro.mysalesapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.mysalesapp.R
import com.bimabagaskhoro.mysalesapp.databinding.ItemsTaskBinding
import com.bimabagaskhoro.mysalesapp.domain.model.ontask.ItemOntask

@SuppressLint("NotifyDataSetChanged")
class OnTaskSuccessAdapter : RecyclerView.Adapter<OnTaskSuccessAdapter.ViewHolder>(){
    private var listData = ArrayList<ItemOntask>()
    var onItemClick: ((ItemOntask) -> Unit)? = null

    fun setData(newListData: List<ItemOntask>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.items_task, parent, false))

    override fun onBindViewHolder(holder: OnTaskSuccessAdapter.ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount()= listData.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemsTaskBinding.bind(itemView)
        fun bind(data: ItemOntask) {
            binding.apply {
                tvTittleName.text = data.name
                tvStatus.text = data.status
            }
        }
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}