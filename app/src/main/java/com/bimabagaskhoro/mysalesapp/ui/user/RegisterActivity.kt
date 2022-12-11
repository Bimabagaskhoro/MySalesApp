package com.bimabagaskhoro.mysalesapp.ui.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.bimabagaskhoro.mysalesapp.R
import com.bimabagaskhoro.mysalesapp.data.Resource
import com.bimabagaskhoro.mysalesapp.databinding.ActivityDetailTaskBinding
import com.bimabagaskhoro.mysalesapp.databinding.ActivityRegisterBinding
import com.bimabagaskhoro.mysalesapp.domain.model.ontask.ItemOntask
import com.bimabagaskhoro.mysalesapp.domain.model.users.ItemUsers
import com.bimabagaskhoro.mysalesapp.domain.model.users.ItemUsersLogin
import com.bimabagaskhoro.mysalesapp.vm.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private val viewModel: UsersViewModel by viewModels()
    private lateinit var binding: ActivityRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnRegister.setOnClickListener {
                onRegisterSave()
            }
            tvLogin.setOnClickListener {
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun onRegisterSave() {
        val name = binding.edtName.text.toString().trim()
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        val dataOnRegister = ItemUsers(name, email,password)
        viewModel.postOnTask(dataOnRegister).observe(this) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressbar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                }
                is Resource.Error -> {
                    binding.progressbar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}