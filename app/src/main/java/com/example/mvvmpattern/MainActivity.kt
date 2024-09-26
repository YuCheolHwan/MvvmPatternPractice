package com.example.mvvmpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mvvmpattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var viewModel = ViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel

        viewModel.toastMessage.observe(this, Observer {
            Toast.makeText(this,"$it 번을 클릭했습니다.",Toast.LENGTH_SHORT).show()
        })
        viewModel.checkPasswordMessage.observe(this,Observer{
            if(viewModel.checkPasswordMessage.value == true){
                binding.messageSuccess.visibility = View.VISIBLE
            }else{
                binding.messageSuccess.visibility = View.INVISIBLE
            }

        })
    }


}