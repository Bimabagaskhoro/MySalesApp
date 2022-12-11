package com.bimabagaskhoro.mysalesapp.ui.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.bimabagaskhoro.mysalesapp.R
import com.bimabagaskhoro.mysalesapp.data.Resource
import com.bimabagaskhoro.mysalesapp.databinding.ActivityDetailTaskBinding
import com.bimabagaskhoro.mysalesapp.domain.model.ontask.ItemOntask
import com.bimabagaskhoro.mysalesapp.domain.model.task.ItemTask
import com.bimabagaskhoro.mysalesapp.vm.OnTaskSuccessViewModel
import com.bimabagaskhoro.mysalesapp.vm.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTaskActivity : AppCompatActivity() {
    private val viewModelOnTask: OnTaskSuccessViewModel by viewModels()
    private val viewModel: TaskViewModel by viewModels()

    private lateinit var binding: ActivityDetailTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvname: TextView = findViewById(R.id.tv_name_detail)
        val item = intent.getParcelableExtra<ItemTask>(EXTRA_DATA) as ItemTask
        val locationUri = item.location
        val idTask = item.id
        tvname.text = item.name

        binding.apply {
            buttonSave.setOnClickListener {
                onTaskSave()
                onTaskDelete(idTask)
            }
            buttonNavigation.setOnClickListener { onNavigation(locationUri) }
        }
    }

    private fun onTaskSave() {
        val name = binding.tvNameDetail.text.toString().trim()
        val location = binding.tvNameDetail.text.toString().trim()
        val statusTask = "Success"
        val capture = "test"

        val dataOnTask = ItemOntask(name, capture,location,"0", statusTask)
        viewModelOnTask.postOnTask(dataOnTask).observe(this) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressbar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    binding.progressbar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun onTaskDelete(idTask: String) {
        val method = "delete"
        viewModel.deleteTask(idTask.toInt(), method).observe(this) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressbar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    binding.progressbar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun onNavigation(locationUri: String) {

    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}