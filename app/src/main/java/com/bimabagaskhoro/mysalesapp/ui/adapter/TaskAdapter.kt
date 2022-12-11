package com.bimabagaskhoro.mysalesapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.mysalesapp.R
import com.bimabagaskhoro.mysalesapp.databinding.ItemsTaskBinding
import com.bimabagaskhoro.mysalesapp.domain.model.task.ItemTask
import com.bimabagaskhoro.mysalesapp.ui.task.DetailTaskActivity

@SuppressLint("NotifyDataSetChanged")
class TaskAdapter : RecyclerView.Adapter<TaskAdapter.ViewHolder>(){
    private var listData = ArrayList<ItemTask>()

    fun setData(newListData: List<ItemTask>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.items_task, parent, false))

    override fun onBindViewHolder(holder: TaskAdapter.ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount()= listData.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemsTaskBinding.bind(itemView)
        fun bind(data: ItemTask) {
            binding.apply {
                tvLevel.text = data.level
                tvTittleName.text = data.name
                tvStatus.text = data.status
            }
            itemView.setOnClickListener {
                val moveDetail = Intent(itemView.context, DetailTaskActivity::class.java)
                moveDetail.putExtra(DetailTaskActivity.EXTRA_DATA,data)
                ContextCompat.startActivity(itemView.context, moveDetail, null)
            }
        }
    }
}