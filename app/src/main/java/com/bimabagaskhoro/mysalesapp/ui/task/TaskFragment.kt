package com.bimabagaskhoro.mysalesapp.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bimabagaskhoro.mysalesapp.R
import com.bimabagaskhoro.mysalesapp.data.Resource
import com.bimabagaskhoro.mysalesapp.databinding.FragmentTaskBinding
import com.bimabagaskhoro.mysalesapp.ui.adapter.TaskAdapter
import com.bimabagaskhoro.mysalesapp.vm.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()
    private lateinit var adapter: TaskAdapter

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TaskAdapter()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.getAllTask().observe(viewLifecycleOwner) {
            when(it){
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    adapter.setData(it.data!!)
                    binding.apply {
                        progressbar.visibility = View.GONE
                        rvTask.adapter = adapter
                        rvTask.layoutManager = GridLayoutManager(context, 1)
                        rvTask.setHasFixedSize(true)
//                        adapter.onItemClick = {
//                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}