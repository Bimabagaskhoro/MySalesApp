package com.bimabagaskhoro.mysalesapp.ui.ontasksuccess

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bimabagaskhoro.mysalesapp.R
import com.bimabagaskhoro.mysalesapp.data.Resource
import com.bimabagaskhoro.mysalesapp.databinding.FragmentOnTaskSuccessBinding
import com.bimabagaskhoro.mysalesapp.databinding.FragmentTaskBinding
import com.bimabagaskhoro.mysalesapp.ui.adapter.OnTaskSuccessAdapter
import com.bimabagaskhoro.mysalesapp.ui.adapter.TaskAdapter
import com.bimabagaskhoro.mysalesapp.vm.OnTaskSuccessViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnTaskSuccessFragment : Fragment() {

    private val viewModel : OnTaskSuccessViewModel by viewModels()
    private lateinit var adapter: OnTaskSuccessAdapter

    private var _binding: FragmentOnTaskSuccessBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnTaskSuccessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = OnTaskSuccessAdapter()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.getAllOnTask().observe(viewLifecycleOwner) {
            when(it){
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    adapter.setData(it.data!!)
                    binding.apply {
                        progressbar.visibility = View.GONE
                        rvOnTask.adapter = adapter
                        rvOnTask.layoutManager = GridLayoutManager(context, 1)
                        rvOnTask.setHasFixedSize(true)
                        adapter.onItemClick = {
                        }
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