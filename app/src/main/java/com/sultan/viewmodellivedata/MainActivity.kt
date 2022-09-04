package com.sultan.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sultan.viewmodellivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.currentNumber.observe(this , Observer {
          binding.tvTextView.text = it.toString()
        })
        viewModel.currentBoolean.observe(this , Observer {
            binding.tvBooleanText.text = it.toString()
        })
        incrementText()
    }

    private fun incrementText(){
        binding.btnButton.setOnClickListener{
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 ==0
        }
    }
}