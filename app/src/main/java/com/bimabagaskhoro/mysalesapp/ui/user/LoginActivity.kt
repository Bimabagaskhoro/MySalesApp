package com.bimabagaskhoro.mysalesapp.ui.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.bimabagaskhoro.mysalesapp.data.Resource
import com.bimabagaskhoro.mysalesapp.databinding.ActivityLoginBinding
import com.bimabagaskhoro.mysalesapp.ui.MainActivity
import com.bimabagaskhoro.mysalesapp.vm.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel: UsersViewModel by viewModels()
    private var session: Boolean = false
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        session = viewModel.loginSession
        if (session) {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        } else {
            binding.btnLogin.setOnClickListener {
                onLogin()
            }
        }
        binding.tvRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onLogin() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()
        viewModel.login(email,password).observe(this) {
            when(it) {
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressbar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    viewModel.setSession(!session)
                    viewModel.setUserToken(it.data?.token!!)
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
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