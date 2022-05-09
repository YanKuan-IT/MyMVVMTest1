package com.example.mymvvmtest1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mymvvmtest1.R
import com.example.mymvvmtest1.databinding.ActivityMainBinding
import com.example.mymvvmtest1.logutil.LogUtil
import com.example.mymvvmtest1.viewmodel.APIViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(APIViewModel::class.java)

        binding.vm = viewModel

        login_bt.setOnClickListener {
            LogUtil.log("1 MainActivity")

            val username = username_et.text.toString().trim()
            val pwd = pwd_et.text.toString().trim()
            viewModel.requestLogin(username, pwd)
        }

        register_bt.setOnClickListener {
            val username = username_et.text.toString().trim()
            val pwd = pwd_et.text.toString().trim()
            viewModel.requestRegister(username, pwd)
        }
    }
}